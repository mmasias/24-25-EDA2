package entregas.celayaIker;

public class Subsecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        int i = 0, j = 0;
        int n = s.length(), m = t.length();

        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++; 
            }
            j++; 
        }

        return i == n; 
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("¿Es subsecuencia?: " + esSubsecuencia(s, t));
    }
}
