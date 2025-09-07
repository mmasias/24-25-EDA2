package Reto002.Nivel4;

public class TriangulosPosibles {
    public static void sort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static boolean existeTriangulo(int[] arr) {
        sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] + arr[i + 1] > arr[i + 2]) {
                System.out.println("true (" + arr[i] + "," + arr[i + 1] + "," + arr[i + 2] + ")");
                return true;
            }
        }
        System.out.println("false");
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7};
        existeTriangulo(arr);
    }
}
