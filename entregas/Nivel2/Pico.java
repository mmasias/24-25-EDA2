package Nivel2;

public class Pico {
    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 7, 6, 4, 2 };
        System.out.println(encontrarPicoBruto(arr));
    }

    public static int encontrarPicoBruto(int[] arr) {
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}
