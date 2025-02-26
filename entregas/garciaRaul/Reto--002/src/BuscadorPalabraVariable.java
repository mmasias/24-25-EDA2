public class BuscadorPalabraVariable {
    public int[] buscarPalabra(char[] caracteres, String palabra) {
        int[] resultado = new int[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            char letraActual = palabra.charAt(i);
            boolean encontrada = false;

            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letraActual) {
                    resultado[i] = j;
                    encontrada = true;
                    break;
                }
            }

            if (!encontrada) {

                for (int k = 0; k < resultado.length; k++) {
                    resultado[k] = -1;
                }
                return resultado;
            }
        }

        return resultado;
    }
}