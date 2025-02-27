package entregas.lopezMartin.reto002.src;

public class BusquedaDePalabra {
    
    public static int[] encontrarIndicesUnicos1(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        boolean[] caracteresUsados = new boolean[caracteres.length];
        
        for (int i = 0; i < palabra.length(); i++) {
            char letraActual = palabra.charAt(i);
            boolean encontrado = false;
            
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letraActual && !caracteresUsados[j]) {
                    indices[i] = j;
                    caracteresUsados[j] = true; 
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                for (int j = 0; j < caracteres.length; j++) {
                    if (caracteres[j] == letraActual) {
                        indices[i] = j;
                        encontrado = true;
                        break;
                    }
                }
                
                if (!encontrado) {
                    return new int[0];
                }
            }
        }
        
        return indices;
    }

    public static int[] encontrarIndicesUnicos2(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];

        for (int i = 0; i < palabra.length(); i++) {
            char letraActual = palabra.charAt(i);
            boolean encontrado = false;

            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letraActual) {
                    indices[i] = j;
                    encontrado = true;
                    break;
                }
            }

            if (!encontrado) {
                return new int[0];
            }
        }

        return indices;
    }
    
    public static void main(String[] args) {

        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        
        int[] resultado = encontrarIndicesUnicos1(caracteres, palabra);
        
        if (resultado.length > 0) {
            System.out.print("Índices encontrados: [");
            for (int i = 0; i < resultado.length; i++) {
                System.out.print(resultado[i]);
                if (i < resultado.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
            
        }else{
            System.out.println("No se encontró la palabra en el array.");
        }
        
    }
}
