package entregas.Reyes_David.Reto_002.Nivel1;

public class Montaña {
    public static boolean esMontana(int[] array) {
        if (array.length < 3) return false;
        int i = 0;
        while (i < array.length - 1 && array[i] < array[i + 1]) {
            i++;
        }
        if (i == 0 || i == array.length - 1) return false;
        while (i < array.length - 1 && array[i] > array[i + 1]) {
            i++;
        }
        return i == array.length - 1;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 4, 2};
        System.out.println("Es montaña: " + esMontana(array));
    }
}