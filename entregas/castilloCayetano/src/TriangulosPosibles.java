public class TriangulosPosibles {
    // Completado
    public static void main(String[] args) {
        imprimirTriangulosPosibles();
    }

    public void mostrar() {
        imprimirTriangulosPosibles();
    }

    public static void imprimirTriangulosPosibles() {
        int[] array = { 3, 4, 5, 6, 7 };
        boolean existeTriangulo = encontrarTriangulo(array);
        System.out.println("¿Existe al menos un triángulo? " + existeTriangulo);
        int count = contarTriangulosPosibles(array);
        System.out.println("Número de triángulos posibles: " + count);
    }

    public static boolean encontrarTriangulo(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] > array[k] && array[i] + array[k] > array[j]
                            && array[j] + array[k] > array[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static int contarTriangulosPosibles(int[] array) {
        if (array == null || array.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] > array[k] && array[i] + array[k] > array[j]
                            && array[j] + array[k] > array[i]) {
                        System.out.println("Triángulo posible: (" + array[i] + ", " + array[j] + ", " + array[k] + ")");
                        count++;
                    }
                }
            }
        }
        return count;
    }
}