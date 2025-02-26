public class BusquedaPalabra {
//Completado
    public static void main(String[] args) {
        imprimirIndices();  
    }
    
    public void mostrar() {
        imprimirIndices();
    }

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

    public static void imprimirIndices() {
        char[] array = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
                'l', 'i', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
        String palabra = "Casa";
        int[] indices = buscarIndices(array, palabra);

        for (int indice : indices) {
            System.out.print(indice + " ");
        }
    }

}