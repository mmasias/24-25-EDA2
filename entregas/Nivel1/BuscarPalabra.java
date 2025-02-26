package Nivel1;

public class BuscarPalabra {
    public static void main(String[] args) {
        char[] caracteres = { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' };
        String palabra = "dia";

        int[] resultado = buscarIndices(caracteres, palabra);

        System.out.print("[");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] buscarIndices(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);

            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letra) {
                    indices[i] = j;
                    break;
                }
            }
        }
        return indices;
    }
}
