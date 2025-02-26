package entregas.lopezMartin.ejerciciosAlgoritmos;

public class TripletesSumaCero {
    
    public static void encontrarTripletes(int[] arr) {
        int n = arr.length;
        ordenarArray(arr);

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

    private static void ordenarArray(int[] arr) {
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
        encontrarTripletes(arr);
    }
}
