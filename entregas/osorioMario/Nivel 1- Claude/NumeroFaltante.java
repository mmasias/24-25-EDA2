public class NumeroFaltante {
    public static int encontrarNumeroFaltante(int[] numeros) {
        int n = numeros.length + 1; 
        boolean[] presente = new boolean[n + 1];
        
        for (int i = 0; i < numeros.length; i++) {
            presente[numeros[i]] = true;
        }
        
        // Buscamos el número que falta
        for (int i = 1; i <= n; i++) {
            if (!presente[i]) {
                return i;
            }
        }
        
        return -1; 
    }
    
    public static int encontrarNumeroFaltanteOptimizado(int[] numeros) {
        int n = numeros.length + 1; 
        
        int sumaEsperada = (n * (n + 1)) / 2;
        
        int sumaReal = 0;
        for (int i = 0; i < numeros.length; i++) {
            sumaReal += numeros[i];
        }
        
        return sumaEsperada - sumaReal;
    }
    
    public static int encontrarNumeroFaltanteXOR(int[] numeros) {
        int n = numeros.length + 1;
        
        int xor1 = 0;
        for (int i = 1; i <= n; i++) {
            xor1 ^= i;
        }
        
        int xor2 = 0;
        for (int i = 0; i < numeros.length; i++) {
            xor2 ^= numeros[i];
        }
        
        return xor1 ^ xor2;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        
        int faltante1 = encontrarNumeroFaltante(numeros);
        int faltante2 = encontrarNumeroFaltanteOptimizado(numeros);
        int faltante3 = encontrarNumeroFaltanteXOR(numeros);
        
        System.out.println("Número faltante (método 1): " + faltante1);
        System.out.println("Número faltante (método 2): " + faltante2);
        System.out.println("Número faltante (método 3): " + faltante3);
    }
}