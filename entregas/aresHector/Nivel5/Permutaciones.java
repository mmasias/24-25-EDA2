import java.util.*;

public class Permutaciones {
    public static void generarPermutaciones(String str, String prefijo, List<String> resultado) {
        if (str.length() == 0) {
            resultado.add(prefijo);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            generarPermutaciones(str.substring(0, i) + str.substring(i + 1), 
                                 prefijo + str.charAt(i), 
                                 resultado);
        }
    }

    public static List<String> obtenerPermutaciones(String str) {
        List<String> resultado = new ArrayList<>();
        generarPermutaciones(str, "", resultado);
        return resultado;
    }

    public static void main(String[] args) {
        String str = "abc";
        System.out.println(obtenerPermutaciones(str));
    }
}
