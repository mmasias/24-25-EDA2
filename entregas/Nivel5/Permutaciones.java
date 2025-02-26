package Nivel5;

public class Permutaciones {
    public static void main(String[] args) {
        String entrada = "aabc";
        char[] caracteres = entrada.toCharArray();
        ordenarCaracteres(caracteres);
        generarPermutacionesUnicas(new String(caracteres), "", new boolean[entrada.length()]);
    }

    public static void generarPermutacionesUnicas(String cadena, String prefijo, boolean[] usados) {
        if (prefijo.length() == cadena.length()) {
            System.out.println(prefijo);
            return;
        }

        for (int i = 0; i < cadena.length(); i++) {
            if (usados[i] || (i > 0 && cadena.charAt(i) == cadena.charAt(i - 1) && !usados[i - 1])) {
                continue;
            }

            usados[i] = true;
            generarPermutacionesUnicas(cadena, prefijo + cadena.charAt(i), usados);
            usados[i] = false;
        }
    }

    public static void ordenarCaracteres(char[] caracteres) {
        for (int i = 0; i < caracteres.length - 1; i++) {
            for (int j = i + 1; j < caracteres.length; j++) {
                if (caracteres[i] > caracteres[j]) {
                    char temp = caracteres[i];
                    caracteres[i] = caracteres[j];
                    caracteres[j] = temp;
                }
            }
        }
    }
}
