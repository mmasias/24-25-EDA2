package entregas.PinedaOscar.Reto_002.Nivel4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TriangulosPosibles {
    public static boolean esTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public static List<int[]> encontrarTriangulos(int[] array) {
        Arrays.sort(array); 
        List<int[]> triangulos = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (esTriangulo(array[i], array[j], array[k])) {
                        triangulos.add(new int[]{array[i], array[j], array[k]});
                    }   
                }
            }
        }

        return triangulos;
    }

    public static void main(String[] args) {
        int[] array = {3, 4, 5, 6, 7};
        List<int[]> triangulos = encontrarTriangulos(array);
        System.out.println("Triángulos posibles:");
        for (int[] triangulo : triangulos) {
            System.out.println(Arrays.toString(triangulo));
        }
    }
}