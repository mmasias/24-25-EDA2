class Subsecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        int indexS = 0;
        for (int i = 0; i < t.length() && indexS < s.length(); i++) {
            if (s.charAt(indexS) == t.charAt(i)) {
                indexS++;
            }
        }
        return indexS == s.length();
    }
    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println("¿Es subsecuencia? " + esSubsecuencia(s, t));
    }
}