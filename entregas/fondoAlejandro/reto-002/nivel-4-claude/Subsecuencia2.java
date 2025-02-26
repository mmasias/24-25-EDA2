class Subsecuencia2 {
    
    private static boolean esSubsecuencia(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        
        int indiceS = 0;
        
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == s.charAt(indiceS)) {
                indiceS++;
                
                if (indiceS == s.length()) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        
        boolean resultado = esSubsecuencia(s, t);
        
        System.out.println("¿Es '" + s + "' una subsecuencia de '" + t + "'? " + resultado);
    }
}