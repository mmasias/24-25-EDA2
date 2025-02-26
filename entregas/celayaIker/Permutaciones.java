package entregas.celayaIker;

public class Permutaciones {
    public static void generarPermutaciones(char[] chars, int inicio) {
        if (inicio == chars.length - 1) {
            System.out.println(new String(chars));
            return;
        }

        for (int i = inicio; i < chars.length; i++) {
            intercambiar(chars, inicio, i);
            generarPermutaciones(chars, inicio + 1);
            intercambiar(chars, inicio, i);
        }
    }

    private static void intercambiar(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println("Permutaciones:");
        generarPermutaciones(input.toCharArray(), 0);
    }
}
