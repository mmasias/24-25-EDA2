public class SumaObjetivo {
    
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        int max = 0;
        for (int num : numeros) {
            if (num > max) max = num;
        }
        
        int[] numerosVistos = new int[max + objetivo + 1];
        
        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            
            if (complemento >= 0 && complemento < numerosVistos.length && numerosVistos[complemento] > 0) {
                return new int[]{numerosVistos[complemento] - 1, i};
            }
            
            if (numeros[i] >= 0 && numeros[i] < numerosVistos.length) {
                numerosVistos[numeros[i]] = i + 1;
            }
        }
        
        return new int[]{-1, -1};
    }
    
    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        int[] resultadoOptimizado = encontrarIndices(numeros, objetivo);
        System.out.print("Solución optimizada: [");
        System.out.print(resultadoOptimizado[0] + ", " + resultadoOptimizado[1]);
        System.out.println("]");
    }
}