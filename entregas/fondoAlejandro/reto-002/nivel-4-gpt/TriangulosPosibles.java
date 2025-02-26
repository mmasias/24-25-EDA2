class TriangulosPosibles {
    public static boolean encontrarTriangulo(int[] numeros) {
        if (numeros == null || numeros.length < 3) {
            return false;
        }
        
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (esTriangulo(numeros[i], numeros[j], numeros[k])) {
                        System.out.println("true (" + numeros[i] + ", " + numeros[j] + ", " + numeros[k] + ")");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private static boolean esTriangulo(int a, int b, int c) {
        return a + b > c && a + c > b && b + c > a;
    }
    
    public static void main(String[] args) {
        int[] numeros = {3, 4, 5, 6, 7};
        if (!encontrarTriangulo(numeros)) {
            System.out.println("false");
        }
    }
}
