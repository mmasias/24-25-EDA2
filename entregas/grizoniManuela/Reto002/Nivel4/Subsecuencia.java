package Reto002.Nivel4;

public class Subsecuencia {
    public static boolean esSubsecuencia(String s, String t) {
        int indexT = 0;
        for (int i = 0; i < s.length(); i++) {
            boolean encontrado = false;
            for (int j = indexT; j < t.length(); j++) {
                if (s.charAt(i) == t.charAt(j)) {
                    encontrado = true;
                    indexT = j + 1;
                    break;
                }
            }
            if (!encontrado) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean resultado = esSubsecuencia(s, t);
        System.out.println("Salida: " + resultado);
    }
}

