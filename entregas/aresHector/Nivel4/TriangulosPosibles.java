import java.util.*;

public class TriangulosPosibles {
    public static List<List<Integer>> encontrarTriangulos(int[] arr) {
        List<List<Integer>> resultado = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        resultado.add(Arrays.asList(arr[i], arr[j], arr[k]));
                    }
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7};
        System.out.println(encontrarTriangulos(arr));
    }
}
