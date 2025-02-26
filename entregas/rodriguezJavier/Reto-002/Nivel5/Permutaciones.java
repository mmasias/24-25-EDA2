public class Permutaciones {
    public static void permutar(String s, String prefijo) {
        if (s.length() == 0) {
            System.out.println(prefijo);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String resto = s.substring(0, i) + s.substring(i + 1);
            permutar(resto, prefijo + c);
        }
    }

    public static void main(String[] args) {
        String s = "abc";
        permutar(s, "");
    }
}