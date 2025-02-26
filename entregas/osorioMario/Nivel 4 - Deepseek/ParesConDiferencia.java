import java.util.ArrayList;
import java.util.List;

public class ParesConDiferencia {
    public static List<int[]> encontrarPares(int[] numeros, int k) {
        List<int[]> pares = new ArrayList<>();
        for (int i = 0; i < numeros.length; i++) {
            for (int j = i + 1; j < numeros.length; j++) {
                if (Math.abs(numeros[i] - numeros[j]) == k) {
                    pares.add(new int[]{numeros[i], numeros[j]});
                }
            }
        }
        return pares;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 7, 5, 9, 2, 12, 3};
        int k = 2;
        List<int[]> pares = encontrarPares(numeros, k);
        System.out.println("Pares con diferencia " + k + ":");
        for (int[] par : pares) {
            System.out.println("[" + par[0] + ", " + par[1] + "]");
        }
    }
}