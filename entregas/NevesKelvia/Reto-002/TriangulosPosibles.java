public class TriangulosPosibles {
    
    public static boolean existeTriangulo(int[] numeros) {
        int n = numeros.length;
        
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (numeros[i] + numeros[j] > numeros[k] &&
                        numeros[i] + numeros[k] > numeros[j] &&
                        numeros[j] + numeros[k] > numeros[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] entrada = {3, 4, 5, 6, 7};
        System.out.println("¿Existe un triángulo? " + existeTriangulo(entrada));
    }
}
