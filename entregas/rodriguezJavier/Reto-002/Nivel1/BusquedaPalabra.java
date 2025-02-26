public class BusquedaPalabra {
    public static int[] buscarPalabra(char[] caracteres, String palabra) {
        char[] palabraArray = palabra.toCharArray();
        int[] indices = new int[palabraArray.length];
        for (int i = 0; i < palabraArray.length; i++) {
            boolean encontrado = false;
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == palabraArray[i]) {
                    indices[i] = j;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                throw new IllegalArgumentException("No se encontró la palabra en el array");
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] resultado = buscarPalabra(caracteres, palabra);
        System.out.print("Índices: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}