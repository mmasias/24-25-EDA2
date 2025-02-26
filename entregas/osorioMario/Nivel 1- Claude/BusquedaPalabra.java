public class BusquedaPalabra {
    public static int[] buscarPalabra(char[] caracteres, String palabra) {
        if (palabra.length() != 3) {
            return new int[] {-1, -1, -1};
        }
        
        int[] resultado = new int[3];
        boolean[] encontrados = new boolean[3];
        
        for (int i = 0; i < caracteres.length; i++) {
            for (int j = 0; j < 3; j++) {
                if (!encontrados[j] && caracteres[i] == palabra.charAt(j)) {
                    resultado[j] = i;
                    encontrados[j] = true;
                    break; 
                }
            }
            
            if (encontrados[0] && encontrados[1] && encontrados[2]) {
                return resultado;
            }
        }
        
        return new int[] {-1, -1, -1};
    }
    
    public static int[] buscarPalabraGeneral(char[] caracteres, String palabra) {
        int longitud = palabra.length();
        int[] resultado = new int[longitud];
        boolean[] encontrados = new boolean[longitud];
        
        for (int i = 0; i < caracteres.length; i++) {
            for (int j = 0; j < longitud; j++) {
                if (!encontrados[j] && caracteres[i] == palabra.charAt(j)) {
                    resultado[j] = i;
                    encontrados[j] = true;
                    break; // 
                }
            }
            
            boolean todasEncontradas = true;
            for (boolean encontrado : encontrados) {
                if (!encontrado) {
                    todasEncontradas = false;
                    break;
                }
            }
            
            if (todasEncontradas) {
                return resultado;
            }
        }
        
        int[] noEncontrado = new int[longitud];
        for (int i = 0; i < longitud; i++) {
            noEncontrado[i] = -1;
        }
        return noEncontrado;
    }
    
    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        
        int[] resultado = buscarPalabraGeneral(caracteres, palabra);
        System.out.print("Índices: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        System.out.print("Caracteres: ");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(caracteres[resultado[i]]);
        }
        System.out.println();
    }
}