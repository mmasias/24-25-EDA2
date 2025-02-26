package Nivel1;
public class BusquedaPalabra {
    public static int[] buscarPalabra(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        int index = 0;
        
        for (int i = 0; i < palabra.length(); i++) {
            boolean encontrado = false;
            for (int j = 0; j < caracteres.length; j++) {
                if (palabra.charAt(i) == caracteres[j]) {
                    indices[index++] = j;
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                return new int[] {-1, -1, -1}; 
            }
        }
        return indices;
    }

    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] indices = buscarPalabra(caracteres, palabra);
        System.out.print("Índices: [");
        for (int i = 0; i < indices.length; i++) {
            System.out.print(indices[i]);
            if (i < indices.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
