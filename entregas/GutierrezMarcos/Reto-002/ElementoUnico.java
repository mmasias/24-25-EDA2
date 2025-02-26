public class ElementoUnico {
    
    public static int encontrarUnicoConteo(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        
        int[] conteo = new int[max + 1];
        
        for (int num : array) {
            conteo[num]++;
        }
        
        for (int i = 0; i < conteo.length; i++) {
            if (conteo[i] == 1) {
                return i;
            }
        }
        
        return -1;
    }
    
    public static int encontrarUnicoXOR(int[] array) {
        int resultado = 0;
        
        for (int num : array) {
            resultado ^= num;
        }
        
        return resultado;
    }
    
    public static int encontrarUnicoBusquedaBinaria(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (medio % 2 == 0) {
                if (array[medio] == array[medio + 1]) {
                    izquierda = medio + 2;
                } else {
                    derecha = medio;
                }
            } else {
                if (array[medio] == array[medio - 1]) {
                    izquierda = medio + 1;
                } else {
                    derecha = medio - 1;
                }
            }
        }
        
        return array[izquierda];
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 3, 2};
        
        int resultadoConteo = encontrarUnicoConteo(array);
        System.out.println("Elemento único (conteo): " + resultadoConteo);
        
        int resultadoXOR = encontrarUnicoXOR(array);
        System.out.println("Elemento único (XOR): " + resultadoXOR);
        
        int[] arrayOrdenado = {1, 1, 2, 2, 3};
        int resultadoBinario = encontrarUnicoBusquedaBinaria(arrayOrdenado);
        System.out.println("Elemento único (binario): " + resultadoBinario);
    }
}