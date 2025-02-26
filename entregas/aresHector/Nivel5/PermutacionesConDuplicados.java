import java.util.*;

public class PermutacionesConDuplicados {
    public static void generarPermutaciones(char[] arr, boolean[] usado, StringBuilder temp, Set<String> resultado) {
        if (temp.length() == arr.length) {
            resultado.add(temp.toString());
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (usado[i] || (i > 0 && arr[i] == arr[i - 1] && !usado[i - 1])) continue;
            
            usado[i] = true;
            temp.append(arr[i]);
            generarPermutaciones(arr, usado, temp, resultado);
            usado[i] = false;
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static List<String> obtenerPermutacionesUnicas(String str) {
        List<String> resultado = new ArrayList<>();
        Set<String> conjunto = new LinkedHashSet<>();
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        generarPermutaciones(arr, new boolean[arr.length], new StringBuilder(), conjunto);
        resultado.addAll(conjunto);
        return resultado;
    }

    public static void main(String[] args) {
        String str = "aabc";
        System.out.println(obtenerPermutacionesUnicas(str));
    }
}
