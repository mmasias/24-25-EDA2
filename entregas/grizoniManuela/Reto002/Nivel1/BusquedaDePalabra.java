package Reto002.Nivel1;

public class BusquedaDePalabra {
    public static int[] buscarIndices(char[] array, String palabra) {
        int[] indices = new int[palabra.length()];
        

        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            
            for (int j = 0; j < array.length; j++) {
                if (array[j] == letra) {
                    indices[i] = j; 
                    break;
                }
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        char[] array = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";

        int[] resultado = buscarIndices(array, palabra);
        System.out.print("Índices encontrados: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
}

