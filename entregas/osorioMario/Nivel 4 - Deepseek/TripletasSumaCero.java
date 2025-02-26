import java.util.ArrayList;
import java.util.List;

public class TripletasSumaCero {
    public static List<int[]> encontrarTripletas(int[] numeros) {
        List<int[]> tripletas = new ArrayList<>();
        for (int i = 0; i < numeros.length - 2; i++) {
            for (int j = i + 1; j < numeros.length - 1; j++) {
                for (int k = j + 1; k < numeros.length; k++) {
                    if (numeros[i] + numeros[j] + numeros[k] == 0) {
                        tripletas.add(new int[]{numeros[i], numeros[j], numeros[k]});
                    }
                }
            }
        }
        return tripletas;
    }

    public static void main(String[] args) {
        int[] numeros = {-1, 0, 1, 2, -1, -4};
        List<int[]> tripletas = encontrarTripletas(numeros);
        System.out.println("Tripletas que suman cero:");
        for (int[] t : tripletas) {
            System.out.println("[" + t[0] + ", " + t[1] + ", " + t[2] + "]");
        }
    }
}