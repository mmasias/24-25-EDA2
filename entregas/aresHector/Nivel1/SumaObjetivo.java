import java.util.*;

public class SumaObjetivo {
    public static int[] sumaObjetivo(int[] numeros, int objetivo) {
        Map<Integer, Integer> mapa = new HashMap<>();
        for (int i = 0; i < numeros.length; i++) {
            int complemento = objetivo - numeros[i];
            if (mapa.containsKey(complemento)) {
                return new int[]{mapa.get(complemento), i};
            }
            mapa.put(numeros[i], i);
        }
        return new int[]{-1, -1};  
    }

    public static void main(String[] args) {
        int[] numeros = {3, 2, 9, 8};
        System.out.println(Arrays.toString(sumaObjetivo(numeros, 10))); 
    }
}
