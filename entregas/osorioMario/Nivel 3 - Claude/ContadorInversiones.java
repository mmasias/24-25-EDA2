public class ContadorInversiones {
    static int contarInversiones(int[] arr) {
        return mergeSort(arr, 0, arr.length - 1);
    }
    
    static int mergeSort(int[] arr, int izquierda, int derecha) {
        int contador = 0;
        
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            
            contador += mergeSort(arr, izquierda, medio);
            contador += mergeSort(arr, medio + 1, derecha);
            
            contador += merge(arr, izquierda, medio, derecha);
        }
        
        return contador;
    }
    
    static int merge(int[] arr, int izquierda, int medio, int derecha) {
        int n1 = medio - izquierda + 1;
        int n2 = derecha - medio;
        
        int[] L = new int[n1];
        int[] R = new int[n2];
        
        for (int i = 0; i < n1; i++) {
            L[i] = arr[izquierda + i];
        }
        for (int j = 0; j < n2; j++) {
            R[j] = arr[medio + 1 + j];
        }
        
        int inversiones = 0;
        int i = 0, j = 0, k = izquierda;
        
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k++] = L[i++];
            } else {
                arr[k++] = R[j++];
                
                inversiones += (n1 - i);
            }
        }
        
        while (i < n1) {
            arr[k++] = L[i++];
        }
        
        while (j < n2) {
            arr[k++] = R[j++];
        }
        
        return inversiones;
    }
    
    static void imprimirInversiones(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    System.out.println("(" + arr[i] + "," + arr[j] + ")");
                }
            }
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        
        System.out.println("Número de inversiones: " + contarInversiones(arr.clone()));
        System.out.println("Las inversiones son:");
        imprimirInversiones(arr);
    }
}
