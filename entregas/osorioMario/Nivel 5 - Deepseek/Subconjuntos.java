import java.util.ArrayList;
import java.util.List;

public class Subconjuntos {

    public static List<List<Integer>> generarSubconjuntos(int[] conjunto) {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        generarSubconjuntosHelper(conjunto, 0, new ArrayList<>(), subconjuntos);
        return subconjuntos;
    }

    private static void generarSubconjuntosHelper(int[] conjunto, int indice, List<Integer> actual, List<List<Integer>> subconjuntos) {
        subconjuntos.add(new ArrayList<>(actual));
        for (int i = indice; i < conjunto.length; i++) {
            actual.add(conjunto[i]);
            generarSubconjuntosHelper(conjunto, i + 1, actual, subconjuntos);
            actual.remove(actual.size() - 1);
        }
    }

    public static List<List<Integer>> generarSubconjuntosDeTamanoK(int[] conjunto, int k) {
        List<List<Integer>> subconjuntos = new ArrayList<>();
        generarSubconjuntosDeTamanoKHelper(conjunto, 0, new ArrayList<>(), subconjuntos, k);
        return subconjuntos;
    }

    private static void generarSubconjuntosDeTamanoKHelper(int[] conjunto, int indice, List<Integer> actual, List<List<Integer>> subconjuntos, int k) {
        if (actual.size() == k) {
            subconjuntos.add(new ArrayList<>(actual));
            return;
        }
        for (int i = indice; i < conjunto.length; i++) {
            actual.add(conjunto[i]);
            generarSubconjuntosDeTamanoKHelper(conjunto, i + 1, actual, subconjuntos, k);
            actual.remove(actual.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};
        List<List<Integer>> subconjuntos = generarSubconjuntos(conjunto);
        System.out.println("Subconjuntos: " + subconjuntos);

        int k = 2;
        List<List<Integer>> subconjuntosK = generarSubconjuntosDeTamanoK(conjunto, k);
        System.out.println("Subconjuntos de tamaño " + k + ": " + subconjuntosK);
    }
}