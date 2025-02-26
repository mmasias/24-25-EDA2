public class Subconjuntos {
    public static int[][] generarSubconjuntos(int[] conjunto) {
        int n = conjunto.length;
        // Habrá 2^n subconjuntos
        int totalSubconjuntos = 1 << n; // 2^n
        
        // Crear matriz para almacenar todos los subconjuntos
        // Primero, calculamos los tamaños de cada subconjunto
        int[] tamanios = new int[totalSubconjuntos];
        
        for (int i = 0; i < totalSubconjuntos; i++) {
            int bits = i;
            int count = 0;
            while (bits > 0) {
                count += bits & 1; // Contar bits "1"
                bits >>= 1;
            }
            tamanios[i] = count;
        }
        
        // Crear los arrays para cada subconjunto
        int[][] subconjuntos = new int[totalSubconjuntos][];
        for (int i = 0; i < totalSubconjuntos; i++) {
            subconjuntos[i] = new int[tamanios[i]];
        }
        
        // Llenar los subconjuntos
        for (int i = 0; i < totalSubconjuntos; i++) {
            int bits = i;
            int index = 0;
            
            for (int j = 0; j < n; j++) {
                if ((bits & 1) == 1) {
                    subconjuntos[i][index++] = conjunto[j];
                }
                bits >>= 1;
            }
        }
        
        return subconjuntos;
    }
    
    // Método para generar subconjuntos recursivamente
    public static int[][] generarSubconjuntosRecursivo(int[] conjunto) {
        // Habrá 2^n subconjuntos
        int totalSubconjuntos = 1 << conjunto.length; // 2^n
        
        // Crear una estructura temporal para almacenar resultados mientras construimos
        boolean[][] temp = new boolean[totalSubconjuntos][conjunto.length];
        int[] tamanios = new int[totalSubconjuntos];
        
        // Llamar a la función recursiva con un conjunto vacío inicial
        generarSubconjuntosRecursivo(conjunto, 0, new boolean[conjunto.length], 0, temp, tamanios);
        
        // Convertir la estructura temporal a la forma final
        int[][] subconjuntos = new int[totalSubconjuntos][];
        for (int i = 0; i < totalSubconjuntos; i++) {
            subconjuntos[i] = new int[tamanios[i]];
            int index = 0;
            for (int j = 0; j < conjunto.length; j++) {
                if (temp[i][j]) {
                    subconjuntos[i][index++] = conjunto[j];
                }
            }
        }
        
        return subconjuntos;
    }
    
    private static void generarSubconjuntosRecursivo(int[] conjunto, int index, boolean[] actual, int nivel, 
                                                    boolean[][] resultado, int[] tamanios) {
        if (index == conjunto.length) {
            // Copiar el subconjunto actual al resultado
            for (int i = 0; i < conjunto.length; i++) {
                resultado[nivel][i] = actual[i];
                if (actual[i]) {
                    tamanios[nivel]++;
                }
            }
            return;
        }
        
        // No incluir el elemento actual
        generarSubconjuntosRecursivo(conjunto, index + 1, actual, nivel, resultado, tamanios);
        
        // Incluir el elemento actual
        actual[index] = true;
        generarSubconjuntosRecursivo(conjunto, index + 1, actual, nivel + (1 << index), resultado, tamanios);
        actual[index] = false; // Backtracking
    }
    
    // Reto adicional: generar subconjuntos de tamaño k
    public static int[][] generarSubconjuntosTamanioK(int[] conjunto, int k) {
        // Calcular cuántos subconjuntos de tamaño k hay (combinatorio n sobre k)
        int n = conjunto.length;
        int total = combinatorio(n, k);
        
        int[][] subconjuntos = new int[total][k];
        
        // Usar un array para rastrear los índices actuales
        int[] indices = new int[k];
        for (int i = 0; i < k; i++) {
            indices[i] = i;
        }
        
        for (int i = 0; i < total; i++) {
            // Copiar el subconjunto actual
            for (int j = 0; j < k; j++) {
                subconjuntos[i][j] = conjunto[indices[j]];
            }
            
            // Generar el siguiente subconjunto
            int j = k - 1;
            while (j >= 0 && indices[j] == n - k + j) {
                j--;
            }
            
            if (j < 0) {
                break; // Hemos generado todos los subconjuntos
            }
            
            indices[j]++;
            for (int l = j + 1; l < k; l++) {
                indices[l] = indices[l - 1] + 1;
            }
        }
        
        return subconjuntos;
    }
    
    // Método para calcular combinatorio (n sobre k)
    private static int combinatorio(int n, int k) {
        if (k > n - k) {
            k = n - k; // Optimización: C(n,k) = C(n,n-k)
        }
        
        int resultado = 1;
        for (int i = 0; i < k; i++) {
            resultado *= (n - i);
            resultado /= (i + 1);
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        
        System.out.println("Subconjuntos del conjunto [1, 2, 3]:");
        int[][] subconjuntos = generarSubconjuntos(conjunto);
        
        for (int i = 0; i < subconjuntos.length; i++) {
            System.out.print("[");
            for (int j = 0; j < subconjuntos[i].length; j++) {
                System.out.print(subconjuntos[i][j]);
                if (j < subconjuntos[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        
        System.out.println("\nSubconjuntos generados recursivamente:");
        int[][] subconjuntosRecursivos = generarSubconjuntosRecursivo(conjunto);
        
        for (int i = 0; i < subconjuntosRecursivos.length; i++) {
            System.out.print("[");
            for (int j = 0; j < subconjuntosRecursivos[i].length; j++) {
                System.out.print(subconjuntosRecursivos[i][j]);
                if (j < subconjuntosRecursivos[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
        
        // Probar subconjuntos de tamaño específico
        int k = 2;
        System.out.println("\nSubconjuntos de tamaño " + k + ":");
        int[][] subconjuntosTamanioK = generarSubconjuntosTamanioK(conjunto, k);
        
        for (int i = 0; i < subconjuntosTamanioK.length; i++) {
            System.out.print("[");
            for (int j = 0; j < subconjuntosTamanioK[i].length; j++) {
                System.out.print(subconjuntosTamanioK[i][j]);
                if (j < subconjuntosTamanioK[i].length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
