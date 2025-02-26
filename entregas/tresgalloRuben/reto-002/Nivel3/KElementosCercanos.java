package Nivel3;

class KElementosCercanos {
    public static int[] encontrarKCercanos(int[] numeros, int k, double target) {
        int n = numeros.length;
        double[] distancias = new double[n];
        
        for (int i = 0; i < n; i++) {
            distancias[i] = Math.abs(numeros[i] - target);
        }
        
        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < n; j++) {
                if (distancias[j] < distancias[i]) {
                    intercambiar(distancias, i, j);
                    intercambiar(numeros, i, j);
                }
            }
        }
        
        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = numeros[i];
        }
        
        return resultado;
    }
    
    private static void intercambiar(double[] arr, int i, int j) {
        double temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    private static void intercambiar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 5};
        int k = 2;
        double target = 3.7;
        int[] resultado = encontrarKCercanos(numeros, k, target);
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }
}