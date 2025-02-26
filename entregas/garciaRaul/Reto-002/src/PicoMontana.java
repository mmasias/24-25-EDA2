public class PicoMontana {
    
    public static int encontrarPicoLineal(int[] array) {
        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return array[i];
            }
        }
        
        return -1;
    }
    
    public static int encontrarPicoBinario(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (array[medio] < array[medio + 1]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }
        
        return array[izquierda];
    }
    
    public static int encontrarPicoConDuplicados(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (medio > 0 && array[medio] < array[medio - 1]) {
                derecha = medio - 1;
            } else if (medio < array.length - 1 && array[medio] < array[medio + 1]) {
                izquierda = medio + 1;
            } else {
                return array[medio];
            }
        }
        
        return array[izquierda];
    }
    
    public static void main(String[] args) {
        int[] montana = {1, 3, 5, 7, 6, 4, 2};
        
        int resultadoLineal = encontrarPicoLineal(montana);
        System.out.println("Pico (lineal): " + resultadoLineal);
        
        int resultadoBinario = encontrarPicoBinario(montana);
        System.out.println("Pico (binario): " + resultadoBinario);
        
        int[] montanaConDuplicados = {1, 3, 5, 7, 7, 6, 4, 2};
        int resultadoDuplicados = encontrarPicoConDuplicados(montanaConDuplicados);
        System.out.println("Pico con duplicados: " + resultadoDuplicados);
    }
}