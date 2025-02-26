public class ArrayMontana {

    public static boolean esMontana(int[] arr) {
        int n = arr.length;

        if (n < 3) {
            return false;
        }

        int i = 0;
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        if (i == 0 || i == n - 1) {
            return false;
        }

        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 3, 5, 4, 2 };
        boolean resultado = esMontana(arr);
        System.out.println("¿Es montaña? " + resultado);
    }
}