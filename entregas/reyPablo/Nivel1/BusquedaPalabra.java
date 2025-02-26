public class BusquedaPalabra {
    public static int[] findIndices(char[] arr, String palabra) {
        int[] indices = new int[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            char c = palabra.charAt(i);
            boolean encontrado = false;
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] == c) {
                    indices[i] = j;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) return new int[0];
        }
        return indices;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] result = findIndices(arr, palabra);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
