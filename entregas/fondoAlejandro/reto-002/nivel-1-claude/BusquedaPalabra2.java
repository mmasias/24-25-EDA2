class BusquedaPalabra2 {
    public static int[] buscarIndicesPalabra(char[] caracteres, String palabra) {
        char[] letras = new char[palabra.length()];
        for (int i = 0; i < palabra.length(); i++) {
            letras[i] = palabra.charAt(i);
        }
        
        int[] indices = new int[letras.length];
        
        for (int i = 0; i < indices.length; i++) {
            indices[i] = -1;
        }
        
        for (int i = 0; i < letras.length; i++) {
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letras[i]) {
                    indices[i] = j;
                    break;
                }
            }
        }
        
        for (int i = 0; i < indices.length; i++) {
            if (indices[i] == -1) {
                return new int[0];
            }
        }
        
        return indices;
    }
    
    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        
        int[] resultado = buscarIndicesPalabra(caracteres, palabra);
        
        if (resultado.length > 0) {
            System.out.print("Salida: [");
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i]);
                if (i < resultado.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        } else {
            System.out.println("No se encontraron todas las letras de la palabra");
        }
    }
}