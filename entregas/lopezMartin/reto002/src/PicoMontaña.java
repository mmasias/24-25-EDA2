package entregas.lopezMartin.reto002.src;

public class PicoMontaña {

    public static int encontrarMaximo1(int[] arr) {
        int inicio = 0;
        int fin = arr.length - 1;
        
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (arr[medio] > arr[medio + 1]) {
                fin = medio;
            } else {
                inicio = medio + 1;
            }
        }
        return arr[inicio]; 
    }

    public static int encontrarMaximo2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return arr[i - 1]; 
            }
        }
        return arr[arr.length - 1];
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 6, 4, 2};
        int resultado = encontrarMaximo1(arr);
        System.out.println("Elemento más grande: " + resultado);
    }
}
