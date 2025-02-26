public class SumaObjetivo {
    public static int[] encontrarSumaObjetivo(int[] numeros, int objetivo) {
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1}; 
    }

     public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        System.out.println("Ejemplo: [3, 2, 9, 8], objetivo 10");
        
        
        int[] resultado1 = encontrarSumaObjetivo(numeros, objetivo);
        System.out.println("Solución 1 (fuerza bruta): [" + resultado1[0] + ", " + resultado1[1] + "]");
        
        
    }
}