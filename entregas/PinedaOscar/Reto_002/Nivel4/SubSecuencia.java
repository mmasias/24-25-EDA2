package entregas.PinedaOscar.Reto_002.Nivel4;

public class SubSecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        int i = 0;
        int j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == s.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean resultado = esSubsecuencia(s, t);
        System.out.println("¿Es subsecuencia? " + resultado);
    }
}