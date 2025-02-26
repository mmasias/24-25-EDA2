public class ArrayMontana {
    public static boolean isMountain(int[] arr) {
        if (arr.length < 3) return false;
        int i = 0;
        while (i < arr.length - 1 && arr[i] < arr[i + 1]) i++;
        if (i == 0 || i == arr.length - 1) return false;
        while (i < arr.length - 1 && arr[i] > arr[i + 1]) i++;
        return i == arr.length - 1;
    }

    public static void main(String[] args) {
        int[] entrada = {1, 3, 5, 4, 2};
        System.out.println(isMountain(entrada));
    }
}
