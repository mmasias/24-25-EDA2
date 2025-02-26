public class BúsquedaPalabra {
    public static void main(String[] args) {
        String palabra = "dia";
        char entrada[] = { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' };

        int[] indices = new int[palabra.length()];
        int indiceCount = 0;

        for (int i = 0; i < entrada.length; i++) {
            if (entrada[i] == palabra.charAt(indiceCount)) {
                indices[indiceCount++] = i;
            }
            if (indiceCount == palabra.length()) {
                break;
            }
        }

        System.out.println("Índices: [" + indices[0] + ", " + indices[1] + ", " + indices[2] + "]");
        System.out.println(
                "Valores: [" + entrada[indices[0]] + ", " + entrada[indices[1]] + ", " + entrada[indices[2]] + "]"
                        + " = " + palabra);
    }
}
