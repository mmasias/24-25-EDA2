public class BusquedaPalabra {
    
    public static int[] buscarPalabraTresLetras(char[] caracteres, String palabra) {
        if (palabra.length() != 3) {
            return new int[]{-1, -1, -1};
        }
        
        int[] indices = new int[3];
        for (int i = 0; i < 3; i++) {
            indices[i] = -1;
        }
        
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == palabra.charAt(0) && indices[0] == -1) {
                indices[0] = i;
            } else if (caracteres[i] == palabra.charAt(1) && indices[1] == -1) {
                indices[1] = i;
            } else if (caracteres[i] == palabra.charAt(2) && indices[2] == -1) {
                indices[2] = i;
            }
            
            if (indices[0] != -1 && indices[1] != -1 && indices[2] != -1) {
                break;
            }
        }
        
        return indices;
    }
    
    public static int[] buscarPalabraGeneral(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = -1;
        }
        
        for (int i = 0; i < palabra.length(); i++) {
            char letraActual = palabra.charAt(i);
            
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letraActual) {
                    boolean yaUsado = false;
                    for (int k = 0; k < i; k++) {
                        if (indices[k] == j) {
                            yaUsado = true;
                            break;
                        }
                    }
                    
                    if (!yaUsado) {
                        indices[i] = j;
                        break;
                    }
                }
            }
        }
        
        return indices;
    }

    public static int[] buscarPalabraOptimizada(char[] caracteres, String palabra) {
        int[] indices = new int[palabra.length()];
        boolean[] visitados = new boolean[caracteres.length];
        
        for (int i = 0; i < indices.length; i++) {
            indices[i] = -1;
        }
        
        for (int i = 0; i < palabra.length(); i++) {
            char letraActual = palabra.charAt(i);
            
            for (int j = 0; j < caracteres.length; j++) {
                if (caracteres[j] == letraActual && !visitados[j]) {
                    indices[i] = j;
                    visitados[j] = true;
                    break;
                }
            }
        }
        
        return indices;
    }
    
    public static void main(String[] args) {
        char[] caracteres = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        String palabra = "dia";
        
        int[] resultado1 = buscarPalabraTresLetras(caracteres, palabra);
        System.out.print("Solución para 3 letras: [");
        for (int i = 0; i < resultado1.length; i++) {
            System.out.print(resultado1[i]);
            if (i < resultado1.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        int[] resultado2 = buscarPalabraGeneral(caracteres, palabra);
        System.out.print("Solución general: [");
        for (int i = 0; i < resultado2.length; i++) {
            System.out.print(resultado2[i]);
            if (i < resultado2.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        
        int[] resultado3 = buscarPalabraOptimizada(caracteres, palabra);
        System.out.print("Solución optimizada: [");
        for (int i = 0; i < resultado3.length; i++) {
            System.out.print(resultado3[i]);
            if (i < resultado3.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}