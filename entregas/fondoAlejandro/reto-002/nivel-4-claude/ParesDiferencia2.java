class ParesDiferencia2 {
    
    private static void encontrarParesDiferencia(int[] arreglo, int k) {
        System.out.println("Pares con diferencia " + k + ":");
        
        boolean encontrado = false;
        
        for (int i = 0; i < arreglo.length - 1; i++) {
            for (int j = i + 1; j < arreglo.length; j++) {
                int diferencia = Math.abs(arreglo[i] - arreglo[j]);
                
                if (diferencia == k) {
                    int menor = Math.min(arreglo[i], arreglo[j]);
                    int mayor = Math.max(arreglo[i], arreglo[j]);
                    System.out.println("[" + menor + "," + mayor + "]");
                    encontrado = true;
                }
            }
        }
        
        if (!encontrado) {
            System.out.println("No se encontraron pares con diferencia " + k);
        }
    }
    
    public static void main(String[] args) {
        int[] arreglo = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        
        encontrarParesDiferencia(arreglo, k);
    }
}