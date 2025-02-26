class NumeroFaltante2 {
    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1;
        
        int sumaTotal = (n * (n + 1)) / 2;
        
        int sumaActual = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumaActual += numeros[i];
        }
        
        return sumaTotal - sumaActual;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        
        int numeroFaltante = encontrarNumeroFaltante(numeros);
        
        System.out.println("Número faltante: " + numeroFaltante);
    }
}