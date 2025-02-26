package Reto002.Nivel5;

public class Permutaciones {
    public static void permute(char[] arr, int l, int r) {
        if (l == r) {
            System.out.println(new String(arr));
        } else {
            for (int i = l; i <= r; i++) {
                swap(arr, l, i);
                permute(arr, l + 1, r);
                swap(arr, l, i);
            }
        }
    }
    
    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        String s = "abc";
        permute(s.toCharArray(), 0, s.length() - 1);
    }
}

