import java.util.*;

public class BusquedaPalabra {
    public static List<Integer> busquedaPalabra(char[] array, String palabra) {
        Map<Character, Integer> mapa = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            mapa.put(array[i], i);
        }

        List<Integer> indices = new ArrayList<>();
        for (char c : palabra.toCharArray()) {
            if (mapa.containsKey(c)) {
                indices.add(mapa.get(c));
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        char[] array = {'a', 'c', 'd', 'i', 'm', 'r', 't', 'u'};
        System.out.println(busquedaPalabra(array, "dia")); // Output: [2, 3, 0]
    }
}

