public class BusquedaPalabra {
    public static int[] buscarPalabra(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        int encontrados = 0;
        
        for (int i = 0; i < palabra.length(); i++) {
            char letra = palabra.charAt(i);
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letra) {
                    indices[encontrados] = j;
                    encontrados++;
                    break;
                }
            }
        }
        
        return encontrados == palabra.length() ? indices : new int[]{-1};
    }
    
    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        int[] resultado = buscarPalabra(caracteres, palabra);
        
        System.out.print("Índices: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + (i < resultado.length - 1 ? ", " : ""));
        }
        System.out.println("]");
    }
}
