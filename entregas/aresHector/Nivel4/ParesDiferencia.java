import java.util.*;

public class ParesDiferencia {
    public static List<List<Integer>> encontrarPares(int[] arr, int k) {
        List<List<Integer>> resultado = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] - arr[i] == k) {
                    resultado.add(Arrays.asList(arr[i], arr[j]));
                }
            }
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        System.out.println(encontrarPares(arr, k));
    }
}
