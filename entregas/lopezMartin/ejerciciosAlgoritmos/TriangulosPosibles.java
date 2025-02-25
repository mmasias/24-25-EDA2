package entregas.lopezMartin.ejerciciosAlgoritmos;

public class TriangulosPosibles {
    
    public static boolean encontrarTriangulo(int[] arr) {
        int n = arr.length;
        
        ordenarArray(arr);
        
        for (int i = 0; i < n - 2; i++) {
            int a = arr[i], b = arr[i + 1], c = arr[i + 2];

            if (a + b > c) {
                System.out.println("Triángulo encontrado: (" + a + ", " + b + ", " + c + ")");
                return true;
            }
        }
        return false;
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
        int[] arr = {3, 4, 5, 6, 7};
        boolean resultado = encontrarTriangulo(arr);
        System.out.println("¿Existe un triángulo válido? " + resultado);
    }
}
