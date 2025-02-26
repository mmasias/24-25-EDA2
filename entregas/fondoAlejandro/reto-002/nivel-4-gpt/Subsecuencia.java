class Subsecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        int indiceS = 0, indiceT = 0;
        int tamanoS = s.length(), tamanoT = t.length();
        
        while (indiceS < tamanoS && indiceT < tamanoT) {
            if (s.charAt(indiceS) == t.charAt(indiceT)) {
                indiceS++;
            }
            indiceT++;
        }
        
        return indiceS == tamanoS;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println("¿Es subsecuencia? " + esSubsecuencia(s, t));
    }
}
