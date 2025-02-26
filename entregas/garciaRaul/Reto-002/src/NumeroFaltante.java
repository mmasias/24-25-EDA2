public class NumeroFaltante {
    
    public static int encontrarFaltanteSuma(int[] numeros) {
        int n = numeros.length + 1;
        
        int sumaEsperada = (n * (n + 1)) / 2;
        
        int sumaActual = 0;
        for (int num : numeros) {
            sumaActual += num;
        }
        
        return sumaEsperada - sumaActual;
    }
    
    public static int encontrarFaltanteXOR(int[] numeros) {
        int n = numeros.length + 1;
        int xorEsperado = 0;
        for (int i = 1; i <= n; i++) {
            xorEsperado ^= i;
        }
        
        int xorActual = 0;
        for (int num : numeros) {
            xorActual ^= num;
        }

        return xorEsperado ^ xorActual;
    }
    
    public static int encontrarFaltanteIndices(int[] numeros) {
        int n = numeros.length + 1;
        
        for (int i = 0; i < numeros.length; i++) {
            int valor = Math.abs(numeros[i]);
            
            if (valor <= numeros.length) {
                numeros[valor - 1] = -Math.abs(numeros[valor - 1]);
            }
        }
        
        for (int i = 0; i < numeros.length; i++) {
            if (numeros[i] > 0) {
                return i + 1;
            }
        }
        
        return n;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 4, 5, 6};
        
        int[] copia1 = numeros.clone();
        int[] copia2 = numeros.clone();
        
        int resultadoSuma = encontrarFaltanteSuma(copia1);
        System.out.println("Número faltante (suma): " + resultadoSuma);
        
        int resultadoXOR = encontrarFaltanteXOR(copia1);
        System.out.println("Número faltante (XOR): " + resultadoXOR);
        
        int resultadoIndices = encontrarFaltanteIndices(copia2);
        System.out.println("Número faltante (índices): " + resultadoIndices);
    }
}