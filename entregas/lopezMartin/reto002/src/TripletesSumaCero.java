package entregas.lopezMartin.reto002.src;

public class TripletesSumaCero {
    
    public static void encontrarTripletes1(int[] arr) {
        int n = arr.length;
        ordenarArray1(arr);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            int izquierda = i + 1, derecha = n - 1;
            while (izquierda < derecha) {
                int suma = arr[i] + arr[izquierda] + arr[derecha];

                if (suma == 0) {
                    System.out.println("[" + arr[i] + ", " + arr[izquierda] + ", " + arr[derecha] + "]");
                    
                    while (izquierda < derecha && arr[izquierda] == arr[izquierda + 1]) {
                        izquierda++;
                    }
                    while (izquierda < derecha && arr[derecha] == arr[derecha - 1]) {
                        derecha--;
                    }

                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++; 
                } else {
                    derecha--; 
                }
            }
        }
    }

    private static void ordenarArray1(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    public static void encontrarTripletes2(int[] arr) {
        int n = arr.length;

        ordenarArray2(arr);

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }

            boolean encontrado = false;
            int target = -arr[i];
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[j] + arr[k] == target) {
                        System.out.println("[" + arr[i] + ", " + arr[j] + ", " + arr[k] + "]");
                        encontrado = true;
                        break;
                    }
                }
                if (encontrado) {
                    break;
                }
            }
        }
    }

    private static void ordenarArray2(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int clave = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > clave) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = clave;
        }
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        encontrarTripletes1(arr);
    }
}
