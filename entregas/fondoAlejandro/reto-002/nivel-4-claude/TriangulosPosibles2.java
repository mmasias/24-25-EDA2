class TriangulosPosibles2 {
    
    private static boolean sonTrianguloPosible(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
    
    private static boolean encontrarTriangulo(int[] arreglo) {
        for (int i = 0; i < arreglo.length - 2; i++) {
            for (int j = i + 1; j < arreglo.length - 1; j++) {
                for (int k = j + 1; k < arreglo.length; k++) {
                    if (sonTrianguloPosible(arreglo[i], arreglo[j], arreglo[k])) {
                        System.out.println("Triángulo encontrado: (" + arreglo[i] + "," + arreglo[j] + "," + arreglo[k] + ")");
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        int[] arreglo = {3, 4, 5, 6, 7};
        
        boolean resultado = encontrarTriangulo(arreglo);
        System.out.println("¿Se encontró un triángulo posible? " + resultado);
    }
}