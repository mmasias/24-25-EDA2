public class BusquedaPalabra {
    public static int[] buscarIndices(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == palabra.charAt(i)) {
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
        int[] resultado = buscarIndices(caracteres, palabra);
        System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + ", " + resultado[2] + "]");
    }
}
