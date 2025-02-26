package entregas.Reyes_David.Reto_002.Nivel1;

    public class SumaObjetivo {
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
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
        int[] numeros = {3, 2, 9, 8, 7};
        int objetivo = 10;
        int[] indices = encontrarIndices(numeros, objetivo);
        System.out.println("Índices: [" + indices[0] + ", " + indices[1] + "]");
    }
}

