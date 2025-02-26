package entregas.martinezDiego.nivel5;

import java.util.ArrayList;
import java.util.List;

public class Subconjuntos {
    public static List<List<Integer>> encontrarSubconjuntos(int[] conjunto) {
        List<List<Integer>> resultado = new ArrayList<>();
        generarSubconjuntos(conjunto, 0, new ArrayList<>(), resultado);
        return resultado;
    }

    private static void generarSubconjuntos(int[] conjunto, int indice, List<Integer> actual, List<List<Integer>> resultado) {
        if (indice == conjunto.length) {
            resultado.add(new ArrayList<>(actual));
            return;
        }

        generarSubconjuntos(conjunto, indice + 1, actual, resultado);

        actual.add(conjunto[indice]);
        generarSubconjuntos(conjunto, indice + 1, actual, resultado);
        actual.remove(actual.size() - 1);
    }

    public static void main(String[] args) {
        int[] conjunto = {1, 2, 3};

        System.out.print("Entrada: [");
        for (int i = 0; i < conjunto.length; i++) {
            System.out.print(conjunto[i]);
            if (i < conjunto.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        List<List<Integer>> resultado = encontrarSubconjuntos(conjunto);
        System.out.println("Salida: " + resultado);
    }
}

