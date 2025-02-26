import java.util.Arrays;

public class TriangulosPosibles {
    public boolean existeTriangulo(int[] arr) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] + arr[i + 1] > arr[i + 2]) return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7};
        System.out.println(new TriangulosPosibles().existeTriangulo(arr));
    }
}