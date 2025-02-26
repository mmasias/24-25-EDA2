import java.util.ArrayList;
import java.util.List;

public class SumaObjetivo {
    
    public static void main(String[] args) {
        int[] array = {3, 2, 9, 8};
        int objetivo = 11; 
        List<List<Integer>> resultados = encontrarSumaObjetivo(array, objetivo);

        if (resultados.isEmpty()) {
            System.out.println("No hay combinaciones que sumen " + objetivo);
        } else {
            System.out.println("Combinaciones que suman " + objetivo + ": " + resultados);
        }
    }

    public static List<List<Integer>> encontrarSumaObjetivo(int[] array, int objetivo) {
        List<List<Integer>> resultados = new ArrayList<>();
        buscarCombinaciones(array, 0, objetivo, new ArrayList<>(), resultados);
        return resultados;
    }

    public static void buscarCombinaciones(int[] array, int indice, int objetivo, List<Integer> actual, List<List<Integer>> resultados) {
        if (objetivo == 0) {
            resultados.add(new ArrayList<>(actual)); 
            return;
        }
        if (objetivo < 0 || indice >= array.length) {
            return;
        }

        actual.add(array[indice]);
        buscarCombinaciones(array, indice + 1, objetivo - array[indice], actual, resultados);

 
        actual.remove(actual.size() - 1);
        buscarCombinaciones(array, indice + 1, objetivo, actual, resultados);
    }
}