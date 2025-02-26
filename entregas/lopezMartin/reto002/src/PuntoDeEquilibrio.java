package entregas.lopezMartin.reto002.src;

public class PuntoDeEquilibrio {
    
    public static int encontrarIndiceEquilibrio1(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return -1;
        }
        
        int sumaTotal = 0;
        for (int num : numeros) {
            sumaTotal += num;
        }
        
        int sumaIzquierda = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            int sumaDerecha = sumaTotal - sumaIzquierda - numeros[i];
            
            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
            
            sumaIzquierda += numeros[i];
        }
        
        return -1;
    }

    public static int encontrarIndiceEquilibrio2(int[] numeros) {
        if (numeros == null || numeros.length == 0) {
            return -1;
        }

        int n = numeros.length;

        for (int i = 0; i < n; i++) {
            int sumaIzquierda = 0;
            int sumaDerecha = 0;

            for (int j = 0; j < i; j++) {
                sumaIzquierda += numeros[j];
            }

            for (int j = i + 1; j < n; j++) {
                sumaDerecha += numeros[j];
            }

            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 6};
        
        int indice = encontrarIndiceEquilibrio1(numeros);
        
        if (indice != -1) {
            System.out.println("Índice de equilibrio: " + indice);
        } else {
            System.out.println("No existe un índice de equilibrio en este array");
        }
    }
}
