public class TriangulosPosibles {

    public static boolean existeTriangulo(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (esTriangulo(arr[i], arr[j], arr[k])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static void encontrarTodosLosTriangulos(int[] arr) {
        int n = arr.length;
        boolean encontrado = false;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (esTriangulo(arr[i], arr[j], arr[k])) {
                        System.out.println("(" + arr[i] + ", " + arr[j] + ", " + arr[k] + ")");
                        encontrado = true;
                    }
                }
            }
        }
        if (!encontrado) {
            System.out.println("No se encontraron triángulos posibles.");
        }
    }

    private static boolean esTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static void main(String[] args) {
        int[] entrada = {3, 4, 5, 6, 7};
        if (existeTriangulo(entrada)) {
            System.out.println("Se encontró al menos un triángulo posible.");
        } else {
            System.out.println("No se encontró ningún triángulo posible.");
        }

        System.out.println("Todos los triángulos posibles:");
        encontrarTodosLosTriangulos(entrada);
    }
}
