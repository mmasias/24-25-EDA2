package entregas.celayaIker;

import java.util.Arrays;

public class PermutacionesUnicas {
    public static void generarPermutaciones(char[] chars, boolean[] usado, StringBuilder temp) {
        if (temp.length() == chars.length) {
            System.out.println(temp.toString()); 
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (usado[i]) continue; 

            if (i > 0 && chars[i] == chars[i - 1] && !usado[i - 1]) continue;

            usado[i] = true;
            temp.append(chars[i]);
            generarPermutaciones(chars, usado, temp);
            temp.deleteCharAt(temp.length() - 1);
            usado[i] = false; 
        }
    }

    public static void main(String[] args) {
        String input = "aabc";
        char[] chars = input.toCharArray();
        Arrays.sort(chars); 
        boolean[] usado = new boolean[chars.length];

        System.out.println("Permutaciones únicas:");
        generarPermutaciones(chars, usado, new StringBuilder());
    }
}
