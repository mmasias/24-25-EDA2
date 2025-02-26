public class Permutaciones {
    // Completado
    public static void main(String[] args) {
        imprimirPermutaciones("abc");
    }

    public void mostrar() {
        imprimirPermutaciones("abc");
    }

    public static void imprimirPermutaciones(String str) {
        permutar(str, "");
    }

    private static void permutar(String str, String prefijo) {
        if (str.length() == 0) {
            System.out.println(prefijo);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String resto = str.substring(0, i) + str.substring(i + 1);
                permutar(resto, prefijo + ch);
            }
        }
    }
}