public class Permutaciones {
    public void generarPermutaciones(char[] s, int l, int r) {
        if (l == r) {
            System.out.println(new String(s));
        } else {
            for (int i = l; i <= r; i++) {
                intercambiar(s, l, i);
                generarPermutaciones(s, l + 1, r);
                intercambiar(s, l, i);
            }
        }
    }
    private void intercambiar(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    public static void main(String[] args) {
        new Permutaciones().generarPermutaciones("abc".toCharArray(), 0, 2);
    }
}