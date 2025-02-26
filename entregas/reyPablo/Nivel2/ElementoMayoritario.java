public class ElementoMayoritario {
    public static int encontrar(int[] arr) {
        int n = arr.length;
        int candidato = arr[n / 2];
        int count = 0;
        for (int num : arr) {
            if (num == candidato) count++;
        }
        return count > n / 2 ? candidato : -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3};
        System.out.println(encontrar(arr));
    }
}