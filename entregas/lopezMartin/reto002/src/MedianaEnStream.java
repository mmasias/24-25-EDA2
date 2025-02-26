package entregas.lopezMartin.ejerciciosAlgoritmos;

public class MedianaEnStream {
    public static void encontrarMediana(int[] flujo) {
        int n = flujo.length;
        int[] ordenado = new int[n]; 
        int size = 0;  

        for (int i = 0; i < n; i++) {
            insertarOrdenado(ordenado, size, flujo[i]); 
            size++;
            System.out.println(calcularMediana(ordenado, size)); 
        }
    }

    private static void insertarOrdenado(int[] arr, int size, int valor) {
        int i = size - 1;
        while (i >= 0 && arr[i] > valor) {
            arr[i + 1] = arr[i]; 
            i--;
        }
        arr[i + 1] = valor; 
    }

    private static double calcularMediana(int[] arr, int size) {
        if (size % 2 == 1) {
            return arr[size / 2];
        } else {
            return (arr[size / 2 - 1] + arr[size / 2]) / 2.0;
        }
    }

    public static void main(String[] args) {
        int[] flujo = {1, 3, 2, 4, 5};
        encontrarMediana(flujo);
    }
}
