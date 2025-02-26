package entregas.martinezDiego.nivel5;

import java.util.ArrayList;
import java.util.List;

public class Permutaciones {
    public static List<String> generarPermutaciones(String s) {
        List<String> resultado = new ArrayList<>();
        generarPermutacionesRecursivo(s.toCharArray(), 0, resultado);
        return resultado;
    }

    private static void generarPermutacionesRecursivo(char[] s, int inicio, List<String> resultado) {
        if (inicio == s.length) {
            resultado.add(new String(s));
        } else {
            for (int i = inicio; i < s.length; i++) {
                intercambiar(s, inicio, i);
                generarPermutacionesRecursivo(s, inicio + 1, resultado);
                intercambiar(s, inicio, i);  
            }
        }
    }

    private static void intercambiar(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    public static void main(String[] args) {
        String s = "abc";

        System.out.print("Entrada: \"" + s + "\"\n");
        List<String> resultado = generarPermutaciones(s);
        System.out.println("Salida: " + resultado);
    }
}

