public class Permutaciones {
    public static void generarPermutaciones(String str, String resultado) {
        if (str.length() == 0) {
            System.out.println(resultado);
            return;
        }
        for (int i = 0; i < str.length(); i++) {
            generarPermutaciones(str.substring(0, i) + str.substring(i + 1), resultado + str.charAt(i));
        }
    }

    public static void main(String[] args) {
        generarPermutaciones("abc", "");
    }
}