public class ParesDiferencia {
    public static int[][] encontrarPares(int[] numeros, int k) {
        // Primero contamos cuántos pares tienen diferencia k
        int count = 0;
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                int diff = Math.abs(numeros[i] - numeros[j]);
                if (diff == k) {
                    count++;
                }
            }
        }
        
        // Crear array para almacenar todos los pares
        int[][] pares = new int[count][2];
        int index = 0;
        
        // Llenar el array con los pares encontrados
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                int diff = Math.abs(numeros[i] - numeros[j]);
                if (diff == k) {
                    // Guardar el par ordenado (menor, mayor)
                    if (numeros[i] < numeros[j]) {
                        pares[index][0] = numeros[i];
                        pares[index][1] = numeros[j];
                    } else {
                        pares[index][0] = numeros[j];
                        pares[index][1] = numeros[i];
                    }
                    index++;
                }
            }
        }
        
        return pares;
    }
    
    // Reto adicional: optimizar para múltiples k
    public static int[][][] encontrarParesMultiplesK(int[] numeros, int[] ks) {
        int[][][] resultado = new int[ks.length][][];
        
        for (int i = 0; i < ks.length; i++) {
            resultado[i] = encontrarPares(numeros, ks[i]);
        }
        
        return resultado;
    }
    
    // Versión optimizada para múltiples k
    public static int[][][] encontrarParesMultiplesKOptimizado(int[] numeros, int[] ks) {
        // Precomputar todas las diferencias posibles entre pares
        // y mapearlas a los pares correspondientes
        
        // Primero, crear un array para contar cuántos pares para cada k
        int[] contadores = new int[ks.length];
        
        // Para cada par posible
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                int diff = Math.abs(numeros[i] - numeros[j]);
                
                // Verificar si esta diferencia está en nuestro array ks
                for (int k = 0; k < ks.length; k++) {
                    if (diff == ks[k]) {
                        contadores[k]++;
                    }
                }
            }
        }
        
        // Crear arrays de resultados con los tamaños correctos
        int[][][] resultado = new int[ks.length][][];
        for (int k = 0; k < ks.length; k++) {
            resultado[k] = new int[contadores[k]][2];
        }
        
        // Resetear contadores para usarlos como índices
        for (int k = 0; k < ks.length; k++) {
            contadores[k] = 0;
        }
        
        // Rellenar los resultados
        for (int i = 0; i < numeros.length - 1; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                int diff = Math.abs(numeros[i] - numeros[j]);
                
                for (int k = 0; k < ks.length; k++) {
                    if (diff == ks[k]) {
                        // Guardar el par ordenado (menor, mayor)
                        if (numeros[i] < numeros[j]) {
                            resultado[k][contadores[k]][0] = numeros[i];
                            resultado[k][contadores[k]][1] = numeros[j];
                        } else {
                            resultado[k][contadores[k]][0] = numeros[j];
                            resultado[k][contadores[k]][1] = numeros[i];
                        }
                        contadores[k]++;
                    }
                }
            }
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] entrada = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        
        int[][] pares = encontrarPares(entrada, k);
        
        System.out.println("Pares que difieren en " + k + ":");
        for (int i = 0; i < pares.length; i++) {
            System.out.println("[" + pares[i][0] + ", " + pares[i][1] + "]");
        }
        
        // Probar con múltiples k
        int[] ks = {2, 4, 6};
        System.out.println("\nBuscando pares para múltiples k:");
        
        int[][][] resultadosMultiplesK = encontrarParesMultiplesKOptimizado(entrada, ks);
        
        for (int i = 0; i < ks.length; i++) {
            System.out.println("Pares que difieren en " + ks[i] + ":");
            for (int j = 0; j < resultadosMultiplesK[i].length; j++) {
                System.out.println("[" + resultadosMultiplesK[i][j][0] + ", " + resultadosMultiplesK[i][j][1] + "]");
            }
        }
    }
}
