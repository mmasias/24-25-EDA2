public class ArrayRotado {
    public static int encontrarPuntoRotacion(int[] numeros) {
        return busquedaBinaria(numeros, 0, numeros.length - 1);
    }
    
    private static int busquedaBinaria(int[] numeros, int izquierda, int derecha) {
        if (numeros[izquierda] < numeros[derecha]) {
            return 0;
        }
        
        if (izquierda == derecha) {
            return izquierda;
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        
        if (medio < derecha && numeros[medio] > numeros[medio + 1]) {
            return medio + 1;
        }
        
        if (medio > izquierda && numeros[medio - 1] > numeros[medio]) {
            return medio;
        }
        
        if (numeros[izquierda] > numeros[medio]) {
            return busquedaBinaria(numeros, izquierda, medio - 1);
        } else {
            return busquedaBinaria(numeros, medio + 1, derecha);
        }
    }
    
    public static int encontrarPuntoRotacionConDuplicados(int[] numeros) {
        int izquierda = 0;
        int derecha = numeros.length - 1;
        
        if (numeros[izquierda] < numeros[derecha]) {
            return 0;
        }
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (medio < derecha && numeros[medio] > numeros[medio + 1]) {
                return medio + 1;
            }
            if (medio > izquierda && numeros[medio - 1] > numeros[medio]) {
                return medio;
            }
            
            if (numeros[izquierda] == numeros[medio] && numeros[medio] == numeros[derecha]) {
                izquierda++;
                derecha--;
            } 
            else if (numeros[izquierda] <= numeros[medio]) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        
        return izquierda;
    }
    
    public static void main(String[] args) {
        int[] numeros1 = {4, 5, 6, 1, 2, 3};
        int[] numeros2 = {2, 2, 2, 0, 1, 2};
        
        int indice1 = encontrarPuntoRotacion(numeros1);
        int indice2 = encontrarPuntoRotacionConDuplicados(numeros2);
        
        System.out.println("Punto de rotación: " + indice1);
        System.out.println("Punto de rotación (con duplicados): " + indice2);
    }
}
