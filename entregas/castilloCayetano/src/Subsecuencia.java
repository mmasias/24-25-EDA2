public class Subsecuencia {
    // Completado
    public static void main(String[] args) {
        imprimirSubsecuencia();
    }

    public void mostrar() {
        imprimirSubsecuencia();
    }

    public static void imprimirSubsecuencia() {
        String s = "abc";
        String t = "ahbgdc";
        boolean resultado = esSubsecuencia(s, t);
        System.out.println("¿Es subsecuencia? " + resultado);
    }

    public static boolean esSubsecuencia(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int sIndex = 0, tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}