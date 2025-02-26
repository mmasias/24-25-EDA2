public class Permutaciones {

    public static void generarPermutaciones(char[] arr, int indice) {
        if (indice == arr.length - 1) {
            System.out.println(new String(arr));
            return;
        }
        for (int i = indice; i < arr.length; i++) {
            if (!esDuplicado(arr, indice, i)) {
                intercambiar(arr, indice, i);
                generarPermutaciones(arr, indice + 1);
                intercambiar(arr, indice, i);
            }
        }
    }

    private static boolean esDuplicado(char[] arr, int indice, int i) {
        for (int j = indice; j < i; j++) {
            if (arr[j] == arr[i]) {
                return true;
            }
        }
        return false;
    }

    private static void intercambiar(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";
        generarPermutaciones(s.toCharArray(), 0);
    }
}