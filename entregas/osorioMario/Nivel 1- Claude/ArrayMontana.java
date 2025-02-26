public class ArrayMontana {
    public static boolean esMontana(int[] numeros) {
        if (numeros.length < 3) {
            return false;
        }
        int i = 0;
        
        while (i < numeros.length - 1 && numeros[i] < numeros[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == numeros.length - 1) {
            return false;
        }
        
        while (i < numeros.length - 1 && numeros[i] > numeros[i + 1]) {
            i++;
        }
        
        return i == numeros.length - 1;
    }
    
    public static void main(String[] args) {
        int[] numeros1 = {1, 3, 5, 4, 2};
        int[] numeros2 = {1, 2, 3, 4, 5};
        int[] numeros3 = {5, 4, 3, 2, 1};
        int[] numeros4 = {1, 3, 5, 5, 4, 2};
        
        System.out.println("[1, 3, 5, 4, 2] es montaña: " + esMontana(numeros1));
        System.out.println("[1, 2, 3, 4, 5] es montaña: " + esMontana(numeros2));
        System.out.println("[5, 4, 3, 2, 1] es montaña: " + esMontana(numeros3));
        System.out.println("[1, 3, 5, 5, 4, 2] es montaña: " + esMontana(numeros4));
    }
}