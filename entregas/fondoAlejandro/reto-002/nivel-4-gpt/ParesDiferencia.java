class ParesDiferencia {
    public static void encontrarParesDiferencia(int[] numeros, int k) {
        int tamano = numeros.length;
        
        for (int i = 0; i < tamano; i++) {
            for (int j = i + 1; j < tamano; j++) {
                if (Math.abs(numeros[i] - numeros[j]) == k) {
                    System.out.println("[" + numeros[i] + ", " + numeros[j] + "]");
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] numeros = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        System.out.println("Pares con diferencia " + k + ":");
        encontrarParesDiferencia(numeros, k);
    }
}
