package entregas.martinezDiego.nivel1;

public class BusquedaPalabra {
    public static int[] encontrarPalabra(char[] caracteres, char[] palabra) {
        int[] indices = new int[palabra.length];
        int contador = 0;

        for (int i = 0; i < caracteres.length; i++) {
            for (int j = 0; j < palabra.length; j++) {
                if (caracteres[(i + j) % caracteres.length] != palabra[j]) {
                    break;
                }
                if (j == palabra.length - 1) {
                    for (int k = 0; k < palabra.length; k++) {
                        indices[k] = (i + k) % caracteres.length;
                    }
                    return indices;
                }
            }
        }
        return new int[]{-1, -1, -1};
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        char[] palabra = {'d', 'i', 'a'};

        System.out.print("Entrada: [");
        for (int i = 0; i < caracteres.length; i++) {
            System.out.print("'" + caracteres[i] + "'");
            if (i < caracteres.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("], palabra \"" + new String(palabra) + "\"");

        int[] indices = encontrarPalabra(caracteres, palabra);

        System.out.print("Salida: [");
        for (int i = 0; i < indices.length; i++) {
            System.out.print(indices[i]);
            if (i < indices.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}

