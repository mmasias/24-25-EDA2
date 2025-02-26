import java.util.ArrayList;
import java.util.List;

public class BusquedaPalabra {
    public static void main(String[] args) {
        char[] array = {'t', 'c', 'd', 'i', 'm', 'r', 'a', 'u'};
        String palabraClave = "dia";

        List<Integer> indices = encontrarIndices(array, palabraClave);

        if (indices.isEmpty()) {
            System.out.println("La palabra clave no se encuentra en el array.");
        } else {
            System.out.println("Índices de la palabra clave: " + indices);
        }
    }

    public static List<Integer> encontrarIndices(char[] array, String palabraClave) {
        List<Integer> indices = new ArrayList<>();
        int palabraIndex = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == palabraClave.charAt(palabraIndex)) {
                indices.add(i);
                palabraIndex++;

                if (palabraIndex == palabraClave.length()) {
                    return indices;
                }
            }
        }

        indices.clear();
        return indices;
    }
}
