public class PicoMontana {
    public static int encontrarPico(int[] numeros) {
        return busquedaBinaria(numeros, 0, numeros.length - 1);
    }
    
    private static int busquedaBinaria(int[] numeros, int izquierda, int derecha) {
        if (izquierda == derecha) {
            return izquierda; // Solo un elemento
        }
        
        if (izquierda + 1 == derecha) {
            return numeros[izquierda] > numeros[derecha] ? izquierda : derecha; // Dos elementos
        }
        
        int medio = izquierda + (derecha - izquierda) / 2;
        
        // Si el punto medio es el pico
        if (numeros[medio] > numeros[medio - 1] && numeros[medio] > numeros[medio + 1]) {
            return medio;
        }
        
        // Si estamos en la pendiente ascendente
        if (numeros[medio] > numeros[medio - 1] && numeros[medio] < numeros[medio + 1]) {
            return busquedaBinaria(numeros, medio + 1, derecha);
        } else {
            // Estamos en la pendiente descendente
            return busquedaBinaria(numeros, izquierda, medio - 1);
        }
    }
    
    // Versión que maneja elementos duplicados
    public static int encontrarPicoConDuplicados(int[] numeros) {
        int izquierda = 0;
        int derecha = numeros.length - 1;
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            // Caso especial: meseta en el pico
            if (medio > 0 && medio < numeros.length - 1 && 
                numeros[medio] >= numeros[medio - 1] && numeros[medio] >= numeros[medio + 1]) {
                
                // Si tenemos un plateau, encontrar el primer valor máximo
                while (medio > 0 && numeros[medio] == numeros[medio - 1]) {
                    medio--;
                }
                
                return medio;
            }
            
            // Si estamos en pendiente ascendente
            if (medio < numeros.length - 1 && numeros[medio] < numeros[medio + 1]) {
                izquierda = medio + 1;
            } else {
                // Estamos en pendiente descendente o en el pico
                derecha = medio;
            }
        }
        
        return izquierda;
    }
    
    public static void main(String[] args) {
        int[] numeros1 = {1, 3, 5, 7, 6, 4, 2};
        int[] numeros2 = {1, 3, 5, 7, 7, 6, 4, 2};
        
        int indicePico1 = encontrarPico(numeros1);
        int indicePico2 = encontrarPicoConDuplicados(numeros2);
        
        System.out.println("Pico en la montaña: " + numeros1[indicePico1] + " en posición " + indicePico1);
        System.out.println("Pico en la montaña (con duplicados): " + 
                          numeros2[indicePico2] + " en posición " + indicePico2);
    }
}
