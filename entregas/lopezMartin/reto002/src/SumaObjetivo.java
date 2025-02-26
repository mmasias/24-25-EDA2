package entregas.lopezMartin.reto002.src;


public class SumaObjetivo {
    
    public static int[] encontrarIndices1(int[] numeros, int objetivo) {

        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                
                if (numeros[i] + numeros[j] == objetivo) {
                    return new int[] {i, j};
                }
            }
        }
        
        return new int[] {};
    }

    public static int[] encontrarIndices2(int[] numeros, int objetivo) {
        int n = numeros.length;
        
        for (int i = 0; i < n; i++) {
            int complemento = objetivo - numeros[i];
            for (int j = i + 1; j < n; j++) {
                if (numeros[j] == complemento) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[] {};
    }
    
    public static void main(String[] args) {
        
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        int[] resultado = encontrarIndices1(numeros, objetivo);
        
        if (resultado.length > 0) {
            System.out.println("Índices encontrados: [" + resultado[0] + ", " + resultado[1] + "]");
            System.out.println("Números: " + numeros[resultado[0]] + " + " + numeros[resultado[1]] + " = " + objetivo);
        } else {
            System.out.println("No se encontró solución");
        }
    }
}