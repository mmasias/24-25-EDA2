class KElementosCercanos {
    public static int[] encontrarKCercanos(int[] array, int k, double target) {
        int n = array.length;
        int[] resultado = new int[k];
        
        int izquierda = 0, derecha = n - 1;
        while (derecha - izquierda >= k) {
            if (Math.abs(array[izquierda] - target) > Math.abs(array[derecha] - target)) {
                izquierda++;
            } else {
                derecha--;
            }
        }
        
        for (int i = 0; i < k; i++) {
            resultado[i] = array[izquierda + i];
        }
        
        return resultado;
    }
    
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        
        int[] resultado = encontrarKCercanos(array, k, target);
        System.out.print("[");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
