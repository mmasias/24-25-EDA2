class SumaObjetivo2 {
    public static int[] encontrarIndices(int[] numeros, int objetivo) {
        int[] resultado = new int[2];
        
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (numeros[i] + numeros[j] == objetivo) {
                    resultado[0] = i;
                    resultado[1] = j;
                    return resultado;
                }
            }
        }
        
        resultado[0] = -1;
        resultado[1] = -1;
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        int objetivo = 10;
        
        int[] resultado = encontrarIndices(numeros, objetivo);
        
        if (resultado[0] != -1) {
            System.out.println("Salida: índices [" + resultado[0] + ", " + resultado[1] + "]");
        } else {
            System.out.println("No se encontró solución");
        }
    }
}