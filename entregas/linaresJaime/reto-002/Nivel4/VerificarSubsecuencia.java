public class VerificarSubsecuencia {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("¿Es subsecuencia? " + esSubsecuencia(s, t));
        
        String[] secuencias = {"abc", "axc", "hbd"};
        System.out.println("Resultados para múltiples strings:");
        verificarMultiplesSubsecuencias(secuencias, t);
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

    public static void verificarMultiplesSubsecuencias(String[] secuencias, String t) {
        for (String s : secuencias) {
            System.out.println(s + ": " + esSubsecuencia(s, t));
        }
    }
}
