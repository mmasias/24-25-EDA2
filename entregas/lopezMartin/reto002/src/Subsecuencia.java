package entregas.lopezMartin.reto002.src;

public class Subsecuencia {
    
    public static boolean esSubsecuencia(String s, String t) {
        int i = 0;
        int j = 0;
        int m = s.length();
        int n = t.length();

        while (i < m && j < n) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }

        return i == m;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean resultado = esSubsecuencia(s, t);
        System.out.println(resultado);
    }
}
