public class BusquedaPalabra {
    public static int[] buscarPalabra(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            char letraBuscada = palabra.charAt(i);
            indices[i] = -1;

            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letraBuscada) {
                    indices[i] = j;
                    break;
                }
            }

            if (indices[i] == -1) {
                return new int[] { -1 };
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' };
        String palabra = "dia";

        System.out.println("Ejemplo: ['a', 'c', 'd', 'i', 'm', 'r', 't', 'u'], palabra \"dia\"");

        int[] resultado1 = buscarPalabra(caracteres, palabra);
        System.out.print("Solución 1 (fuerza bruta): [");
        for (int i = 0; i < resultado1.length; i++) {
            System.out.print(resultado1[i]);
            if (i < resultado1.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");

    }
}