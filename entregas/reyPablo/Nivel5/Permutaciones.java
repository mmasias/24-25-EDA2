public class Permutaciones {
    public static void generar(char[] arr, int l, int r) {
        if (l == r) {
            System.out.println(new String(arr));
            return;
        }
        for (int i = l; i <= r; i++) {
            swap(arr, l, i);
            generar(arr, l + 1, r);
            swap(arr, l, i);
        }
    }
    
    private static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
    public static void main(String[] args) {
        char[] entrada = "abc".toCharArray();
        generar(entrada, 0, entrada.length - 1);
    }
}