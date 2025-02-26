public class PermutacionesString {
    
    public static void permutar(String texto, int left, int right) {
        if (left == right) {
            System.out.println(texto);
        } else {
            for (int i = left; i <= right; i++) {
                texto = intercambiar(texto, left, i);
                permutar(texto, left + 1, right);
                texto = intercambiar(texto, left, i); 
            }
        }
    }
    
    private static String intercambiar(String texto, int i, int j) {
        char[] charArray = texto.toCharArray();
        char temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
    
    public static void main(String[] args) {
        String entrada = "abc";
        System.out.println("Permutaciones de " + entrada + ":");
        permutar(entrada, 0, entrada.length() - 1);
    }
}
