package Nivel4;

public class Triangulo {
    public static void main(String[] args) {
        int[] arr = { 3, 4, 5, 6, 7 };
        System.out.println(existeTriangulo(arr));
    }

    public static boolean existeTriangulo(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (arr[i] + arr[j] > arr[k] &&
                            arr[i] + arr[k] > arr[j] &&
                            arr[j] + arr[k] > arr[i]) {
                        System.out.println(arr[i] + "," + arr[j] + "," + arr[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
