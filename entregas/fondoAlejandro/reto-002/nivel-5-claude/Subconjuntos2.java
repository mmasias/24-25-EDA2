class Subconjuntos2 {
    public static void generarSubconjuntos(int[] conjunto) {
        int n = conjunto.length;
        int totalSubconjuntos = potencia(2, n);
        
        int[][] resultado = new int[totalSubconjuntos][];
        int[] tamaños = new int[totalSubconjuntos];
        
        for (int i = 0; i < totalSubconjuntos; i++) {
            int contador = 0;
            int temp = i;
            for (int j = 0; j < n; j++) {
                if ((temp & 1) == 1) {
                    contador++;
                }
                temp >>= 1;
            }
            
            resultado[i] = new int[contador];
            tamaños[i] = contador;
            
            int indice = 0;
            temp = i;
            for (int j = 0; j < n; j++) {
                if ((temp & 1) == 1) {
                    resultado[i][indice] = conjunto[j];
                    indice++;
                }
                temp >>= 1;
            }
        }
        
        System.out.print("[");
        for (int i = 0; i < totalSubconjuntos; i++) {
            System.out.print("[");
            for (int j = 0; j < tamaños[i]; j++) {
                System.out.print(resultado[i][j]);
                if (j < tamaños[i] - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("]");
            if (i < totalSubconjuntos - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
    
    private static int potencia(int a, int b) {
        int resultado = 1;
        for (int i = 0; i < b; i++) {
            resultado *= a;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        generarSubconjuntos(conjunto);
    }
}