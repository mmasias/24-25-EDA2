class SumaObjetivo {
    public static int[][] sumaObjetivo(int[] numeros, int objetivo) {
        int maxPairs = (numeros.length * (numeros.length - 1)) / 2;
        int[][] resultado = new int[maxPairs][2];
        int count = 0;
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    resultado[count][0] = i;
                    resultado[count][1] = j;
                    count++;
                }
            }
        }
        
        if (count == 0) {
            return new int[0][0];
        }
        
        int[][] resultadoFinal = new int[count][2];
        for (int i = 0; i < count; i++) {
            resultadoFinal[i] = resultado[i];
        }
        
        return resultadoFinal;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8, 7, 1};
        int objetivo = 10;
        int[][] resultado = sumaObjetivo(numeros, objetivo);
        
        if (resultado.length > 0) {
            for (int[] par : resultado) {
                System.out.println("[" + par[0] + ", " + par[1] + "]");
            }
        } else {
            System.out.println("No hay solución");
        }
    }
}
