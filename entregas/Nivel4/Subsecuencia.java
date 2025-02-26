package Nivel4;

public class Subsecuencia {
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(esSubsecuencia(s, t));
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
}
