package entregas.lopezMartin.ejerciciosAlgoritmos;

public class ArrayMontaña {
    
    public static boolean esMontana(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        
        int i = 0;
        int n = array.length;
        
        while (i + 1 < n && array[i] < array[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == n - 1) {
            return false;
        }
        
        while (i + 1 < n && array[i] > array[i + 1]) {
            i++;
        }
        
        return i == n - 1;
    }
    
    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 4, 2};
        System.out.println("¿Es montaña? " + esMontana(array1));
        
    }
}
