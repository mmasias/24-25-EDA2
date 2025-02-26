import java.util.*;

public class TripletesSumaCero {
    public static List<List<Integer>> encontrarTripletes(int[] arr) {
        List<List<Integer>> resultado = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int izquierda = i + 1, derecha = arr.length - 1;
            while (izquierda < derecha) {
                int suma = arr[i] + arr[izquierda] + arr[derecha];
                if (suma == 0) {
                    resultado.add(Arrays.asList(arr[i], arr[izquierda], arr[derecha]));
                    while (izquierda < derecha && arr[izquierda] == arr[izquierda + 1]) izquierda++;
                    while (izquierda < derecha && arr[derecha] == arr[derecha - 1]) derecha--;
                    izquierda++;
                    derecha--;
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(encontrarTripletes(arr));
    }
}
