package entregas.celayaIker;

public class BusquedaPalabraGeneral {
    public static int[] encontrarIndices(char[] caracteres, String palabra) {
        int longitudPalabra = palabra.length();
        int[] indices = new int[longitudPalabra];
        boolean[] encontrado = new boolean[longitudPalabra];
        int contador = 0; 

        for (int i = 0; i < caracteres.length && contador < longitudPalabra; i++) {
            for (int j = 0; j < longitudPalabra; j++) {
                if (!encontrado[j] && caracteres[i] == palabra.charAt(j)) {
                    indices[j] = i; 
                    encontrado[j] = true;
                    contador++;
                    break; 
                }
            }
        }

        if (contador < longitudPalabra) {
            int[] error = new int[longitudPalabra];
            for (int i = 0; i < longitudPalabra; i++) {
                error[i] = -1;
            }
            return error;
        }

        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'n', 'r', 't', 'u', 'o', 's', 'b'};
        String palabra = "raton"; 

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
