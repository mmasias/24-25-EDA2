package entregas.PinedaOscar.Reto_002.Nivel4;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletesSumaCero {
    public static List<int[]> encontrarTripletes(int[] array) {
        Arrays.sort(array); 
        List<int[]> tripletes = new ArrayList<>();

        for (int i = 0; i < array.length - 2; i++) {
            if (i > 0 && array[i] == array[i - 1]) continue; 
            int izquierda = i + 1;
            int derecha = array.length - 1;

            while (izquierda < derecha) {
                int suma = array[i] + array[izquierda] + array[derecha];
                if (suma == 0) {
                    tripletes.add(new int[]{array[i], array[izquierda], array[derecha]});
                    izquierda++;
                    derecha--;
                    while (izquierda < derecha && array[izquierda] == array[izquierda - 1]) izquierda++; 
                    while (izquierda < derecha && array[derecha] == array[derecha + 1]) derecha--; 
                } else if (suma < 0) {
                    izquierda++;
                } else {
                    derecha--;
                }
            }
        }

        return tripletes;
    }

    public static void main(String[] args) {
        int[] array = {-1, 0, 1, 2, -1, -4};
        List<int[]> tripletes = encontrarTripletes(array);
        System.out.println("Tripletes que suman cero:");
        for (int[] triplete : tripletes) {
            System.out.println(Arrays.toString(triplete));
        }
    }
}