public class Subsecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) i++;
            j++;
        }
        return i == s.length();
    }

    public static void main(String[] args) {
        System.out.println(esSubsecuencia("abc", "ahbgdc"));
    }
}
