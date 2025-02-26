import java.util.*;

public class SubsecuenciaMultiple {
    public static List<Boolean> verificarSubsecuencias(List<String> secuencias, String t) {
        List<Boolean> resultados = new ArrayList<>();
        for (String s : secuencias) {
            resultados.add(esSubsecuencia(s, t));
        }
        return resultados;
    }

    public static boolean esSubsecuencia(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        List<String> secuencias = Arrays.asList("abc", "axc", "bd");
        String t = "ahbgdc";
        System.out.println(verificarSubsecuencias(secuencias, t));
    }
}
