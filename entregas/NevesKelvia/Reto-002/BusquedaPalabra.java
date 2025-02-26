public class BusquedaPalabra {
    
    public static int[] buscarPalabra(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            boolean encontrado = false;
            
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letra) {
                    indices[i] = j;
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                return new int[]{-1}; 
            }
        }
        return indices;
    }
    
    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
              
        int[] resultado = buscarPalabra(caracteres, palabra);
        
        System.out.print("Indices: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + (i < resultado.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
