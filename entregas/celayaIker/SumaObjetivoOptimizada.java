package entregas.celayaIker;

public class SumaObjetivoOptimizada {
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        int[] vistos = new int[1000]; 
        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];

            if (complemento >= 0 && vistos[complemento] != 0) {
                return new int[]{vistos[complemento] - 1, i};
            }

            vistos[numeros[i]] = i + 1; 
        }

        return new int[]{-1, -1}; 
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        int[] resultado = encontrarIndices(numeros, objetivo);
        
        if (resultado[0] != -1) {
            System.out.println("Índices encontrados: [" + resultado[0] + ", " + resultado[1] + "]");
            System.out.println("Números: " + numeros[resultado[0]] + " + " + numeros[resultado[1]] + " = " + objetivo);
        } else {
            System.out.println("No se encontraron dos números que sumen el objetivo.");
        }
    }
}
