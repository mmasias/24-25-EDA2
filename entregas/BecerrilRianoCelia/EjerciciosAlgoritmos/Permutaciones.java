package EjerciciosAlgoritmos;

import java.util.Arrays;

public class Permutaciones {

    public static void permutar(String cadena) {
        char[] caracteres = cadena.toCharArray();
        Arrays.sort(caracteres);
        boolean[] usado = new boolean[caracteres.length];
        permutar(new StringBuilder(), caracteres, usado);
    }

    private static void permutar(StringBuilder prefijo, char[] caracteres, boolean[] usado) {
        if (prefijo.length() == caracteres.length) {
            System.out.println(prefijo.toString());
        } else {
            for (int indice = 0; indice < caracteres.length; indice++) {
                if (usado[indice] || (indice > 0 && caracteres[indice] == caracteres[indice - 1] && !usado[indice - 1])) {
                    continue;
                }
                usado[indice] = true;
                prefijo.append(caracteres[indice]);
                permutar(prefijo, caracteres, usado);
                usado[indice] = false;
                prefijo.deleteCharAt(prefijo.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String entrada = "aabc";
        System.out.println("Permutaciones de " + entrada + ":");
        permutar(entrada);
    }
}