public class BusquedaPalabra {
    public static int[] encontrarIndices(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            for (int j = 0; j < caracteres.length; j++) {
                if (palabra.charAt(i) == caracteres[j]) {
                    indices[i] = j;
                    break;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] indices = encontrarIndices(caracteres, palabra);
        System.out.print("Índices: [");
        for (int i = 0; i < indices.length; i++) {
            System.out.print(indices[i] + (i < indices.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}