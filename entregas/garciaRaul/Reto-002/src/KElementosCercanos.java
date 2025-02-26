public class KElementosCercanos {
    
    public static int[] encontrarCercanosFuerzaBruta(int[] array, int k, double target) {
        double[] distancias = new double[array.length];
        
        for (int i = 0; i < array.length; i++) {
            distancias[i] = Math.abs(array[i] - target);
        }
        
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            int menorIndice = 0;
            for (int j = 1; j < array.length; j++) {
                if (distancias[j] < distancias[menorIndice]) {
                    menorIndice = j;
                }
            }
            
            resultado[i] = array[menorIndice];
            distancias[menorIndice] = Double.MAX_VALUE;
        }
        
        return resultado;
    }
    
    public static int[] encontrarCercanosBinario(int[] array, int k, double target) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (derecha - izquierda + 1 > k) {
            if (Math.abs(array[izquierda] - target) > Math.abs(array[derecha] - target)) {
                izquierda++;
            } else {
                derecha--;
            }
        }
        
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = array[izquierda + i];
        }
        
        return resultado;
    }
    
    public static int[] encontrarCercanosConDosApuntadores(int[] array, int k, double target) {
        int indiceInsercion = buscarPosicionInsercion(array, target);
        
        int izquierda = indiceInsercion - 1;
        int derecha = indiceInsercion;
        
        int[] resultado = new int[k];
        int indice = 0;
        
        while (indice < k) {
            if (izquierda < 0) {
                resultado[indice++] = array[derecha++];
            } else if (derecha >= array.length) {
                resultado[indice++] = array[izquierda--];
            } else {
                double diferenciaIzquierda = Math.abs(array[izquierda] - target);
                double diferenciaDerecha = Math.abs(array[derecha] - target);
                
                if (diferenciaIzquierda <= diferenciaDerecha) {
                    resultado[indice++] = array[izquierda--];
                } else {
                    resultado[indice++] = array[derecha++];
                }
            }
        }
        
        return resultado;
    }
    
    private static int buscarPosicionInsercion(int[] array, double target) {
        int izquierda = 0;
        int derecha = array.length - 1;
        
        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            
            if (array[medio] == target) {
                return medio;
            } else if (array[medio] < target) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        
        return izquierda;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        
        int[] resultadoFuerzaBruta = encontrarCercanosFuerzaBruta(array, k, target);
        System.out.print("K elementos más cercanos (fuerza bruta): ");
        for (int num : resultadoFuerzaBruta) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] resultadoBinario = encontrarCercanosBinario(array, k, target);
        System.out.print("K elementos más cercanos (binario): ");
        for (int num : resultadoBinario) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        int[] resultadoDosApuntadores = encontrarCercanosConDosApuntadores(array, k, target);
        System.out.print("K elementos más cercanos (dos apuntadores): ");
        for (int num : resultadoDosApuntadores) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
