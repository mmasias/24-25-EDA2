import java.util.*;

public class Subconjuntos {
    public static void generarSubconjuntos(int[] arr, int index, List<Integer> temp, List<List<Integer>> resultado) {
        if (index == arr.length) {
            resultado.add(new ArrayList<>(temp));
            return;
        }

        
        generarSubconjuntos(arr, index + 1, temp, resultado);

        
        temp.add(arr[index]);
        generarSubconjuntos(arr, index + 1, temp, resultado);
        temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> obtenerSubconjuntos(int[] arr) {
        List<List<Integer>> resultado = new ArrayList<>();
        generarSubconjuntos(arr, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(obtenerSubconjuntos(arr));
    }
}
