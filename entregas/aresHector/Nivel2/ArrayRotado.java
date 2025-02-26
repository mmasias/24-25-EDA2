public class ArrayRotado {
    public static int encontrarRotacion(int[] arr) {
        int izquierda = 0, derecha = arr.length - 1;

        while (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arr[medio] > arr[derecha]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }

        return izquierda;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 1, 2, 3};
        System.out.println(encontrarRotacion(arr));
    }
}
