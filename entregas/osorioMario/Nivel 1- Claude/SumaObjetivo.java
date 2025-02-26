public class SumaObjetivo {
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    return new int[] {i, j};
                }
            }
        }
        return new int[] {-1, -1};
    }
    
    public static int[] encontrarIndicesOptimizado(int[] numeros, int objetivo) {
        final int MAX_VALOR = 1000; 
        int[] indices = new int[MAX_VALOR];
        
        for (int i = 0; i < MAX_VALOR; i++) {
            indices[i] = -1;
        }
        
        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            
            if (complemento >= 0 && complemento < MAX_VALOR && indices[complemento] != -1) {
                return new int[] {indices[complemento], i};
            }
            
            if (numeros[i] >= 0 && numeros[i] < MAX_VALOR) {
                indices[numeros[i]] = i;
            }
        }
        
        return new int[] {-1, -1};
    }
    
    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        int[] resultado = encontrarIndicesOptimizado(numeros, objetivo);
        System.out.println("Índices: [" + resultado[0] + ", " + resultado[1] + "]");
        System.out.println("Valores: " + numeros[resultado[0]] + " + " + numeros[resultado[1]] + " = " + objetivo);
    }
}