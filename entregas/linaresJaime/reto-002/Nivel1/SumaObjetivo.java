public class SumaObjetivo {
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        int[][] tabla = new int[numeros.length][2];
        int size = 0;

        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            
            for (int j = 0; j < size; j++) {
                if (tabla[j][0] == complemento) {
                    return new int[]{tabla[j][1], i};
                }
            }
            
            tabla[size][0] = numeros[i];
            tabla[size][1] = i;
            size++;
        }
        return new int[]{-1, -1};
    }

    public static int[] buscarPalabra(char[] caracteres, String palabra) {
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
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        int[] resultado = encontrarIndices(numeros, objetivo);
        System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + "]");

        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] indicesPalabra = buscarPalabra(caracteres, palabra);
        System.out.print("Índices de la palabra: [");
        for (int i = 0; i < indicesPalabra.length; i++) {
            System.out.print(indicesPalabra[i]);
            if (i < indicesPalabra.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}
