package Nivel2;

public class RotacionArray {
    public static void main(String[] args) {
        int[] arr = { 4, 5, 6, 1, 2, 3 };
        System.out.println(encontrarRotacionBruto(arr));
    }

    public static int encontrarRotacionBruto(int[] arr) {
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[minIndex]) {
                minIndex = i;
            }
        }
        return minIndex;
    }
}
