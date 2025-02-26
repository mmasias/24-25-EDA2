package entregas.celayaIker;

public class SubsecuenciaMultiple {
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

    public static void verificarMultiplesSubsecuencias(String[] sArr, String t) {
        for (String s : sArr) {
            System.out.println("¿Es \"" + s + "\" subsecuencia de \"" + t + "\"? " + esSubsecuencia(s, t));
        }
    }

    public static void main(String[] args) {
        String[] sArr = {"abc", "axc", "bcd", "hbg"};
        String t = "ahbgdc";
        verificarMultiplesSubsecuencias(sArr, t);
    }
}
