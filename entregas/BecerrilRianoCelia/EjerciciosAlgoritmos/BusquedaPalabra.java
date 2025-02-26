package EjerciciosAlgoritmos;

public class BusquedaPalabra {

    public static int[] encontrarIndices(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        int indicePalabra = 0;

        for (int indiceLetra = 0; indiceLetra < palabra.length(); indiceLetra++) {
            char letra = palabra.charAt(indiceLetra);
            boolean encontrado = false;

            for (int indiceCaracter = 0; indiceCaracter < caracteres.length; indiceCaracter++) {
                if (caracteres[indiceCaracter] == letra) {
                    indices[indicePalabra++] = indiceCaracter;
                    encontrado = true;
                    
                }
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] resultado = encontrarIndices(caracteres, palabra);

        if (resultado.length == 0) {
            System.out.println("No se encontraron índices que conformen la palabra.");
        } else {
            System.out.print("Índices: [");
            for (int indice = 0; indice < resultado.length; indice++) {
                System.out.print(resultado[indice]);
                if (indice < resultado.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}