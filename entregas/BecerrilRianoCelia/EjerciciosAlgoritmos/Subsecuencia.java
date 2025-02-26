package EjerciciosAlgoritmos;

public class Subsecuencia {

    public static boolean esSubsecuencia(String subsecuencia, String secuencia) {
        int indiceSubsecuencia = 0, indiceSecuencia = 0;
        while (indiceSubsecuencia < subsecuencia.length() && indiceSecuencia < secuencia.length()) {
            if (subsecuencia.charAt(indiceSubsecuencia) == secuencia.charAt(indiceSecuencia)) {
                indiceSubsecuencia++;
            }
            indiceSecuencia++;
        }
        return indiceSubsecuencia == subsecuencia.length();
    }

    public static void main(String[] args) {
        String[] subsecuencias = {"abc", "axc", "ahbgdc"};
        String secuencia = "ahbgdc";

        for (String subsecuencia : subsecuencias) {
            boolean resultado = esSubsecuencia(subsecuencia, secuencia);
            System.out.println("¿Es '" + subsecuencia + "' una subsecuencia de '" + secuencia + "'? " + resultado);
        }
    }
}