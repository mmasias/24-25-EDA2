package nivel5;

public class Permutaciones {
    public static void main(String[] args) {
        String entrada = "abc";
        permutaciones(entrada, "");
    }

    public static void permutaciones(String str, String prefijo) {
        if (str.length() == 0) {
            System.out.println(prefijo);
        } else {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                String resto = str.substring(0, i) + str.substring(i + 1);
                permutaciones(resto, prefijo + ch);
            }
        }
    }
}