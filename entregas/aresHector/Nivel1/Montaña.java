public public class Montaña {
    public static boolean esMontana(int[] arr) {
        if (arr.length < 3) return false;

        int i = 0, n = arr.length;

        while (i + 1 < n && arr[i] < arr[i + 1]) i++;

        if (i == 0 || i == n - 1) return false; 

        while (i + 1 < n && arr[i] > arr[i + 1]) i++;

        return i == n - 1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 2};
        System.out.println(esMontana(arr)); // Output: true
    }
}
 {
    
}
