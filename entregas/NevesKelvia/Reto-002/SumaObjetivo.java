public class SumaObjetivo {
    
    public static int[] sumaObjetivoON2(int[] numeros, int objetivo) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; 
    }
    
   
    public static int[] sumaObjetivoON(int[] numeros, int objetivo) {
        int[] indices = new int[objetivo + 1];
        for (int i = 0; i < indices.length; i++) {
            indices[i] = -1; 
        }
        
        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            if (complemento >= 0 && complemento < indices.length && indices[complemento] != -1) {
                return new int[]{indices[complemento], i};
            }
            indices[numeros[i]] = i; 
        }
        return new int[]{-1, -1}; 
    }
    
    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        
        int[] resultado1 = sumaObjetivoON2(numeros, objetivo);
        System.out.println("O(n^2): [" + resultado1[0] + ", " + resultado1[1] + "]");
        
     
        int[] resultado2 = sumaObjetivoON(numeros, objetivo);
        System.out.println("O(n): [" + resultado2[0] + ", " + resultado2[1] + "]");
    }
}
