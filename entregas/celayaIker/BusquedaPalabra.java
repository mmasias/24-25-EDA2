package entregas.celayaIker;

public class BusquedaPalabra {
    public static int[] encontrarIndices(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        boolean[] encontrado = new boolean[palabra.length()];
        int contador = 0; 

        for (int i = 0; i < caracteres.length && contador < palabra.length(); i++) {
            for (int j = 0; j < palabra.length(); j++) {
                if (!encontrado[j] && caracteres[i] == palabra.charAt(j)) {
                    indices[j] = i; 
                    encontrado[j] = true; 
                    contador++;
                    break; 
                }
            }
        }

        if (contador < palabra.length()) {
            return new int[]{-1, -1, -1};
        }

        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";

        int[] resultado = encontrarIndices(caracteres, palabra);

        if (resultado[0] != -1) {
            System.out.print("Índices encontrados: [");
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i]);
                if (i < resultado.length - 1) System.out.print(", ");
            }
            System.out.println("]");
        } else {
            System.out.println("No se encontraron todas las letras.");
        }
    }
}

