package Nivel1;
public class ArrayMontana {
    public static boolean esArrayMontana(int[] arr) {
        int n = arr.length;
        if (n < 3) return false;
        int i = 0;
        while (i < n - 1 && arr[i] < arr[i + 1]) i++;
        if (i == 0 || i == n - 1) return false;
        while (i < n - 1 && arr[i] > arr[i + 1]) i++;
        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};
        boolean esMontana = esArrayMontana(arr);
        System.out.println("Es montaña: " + esMontana);
    }
}
