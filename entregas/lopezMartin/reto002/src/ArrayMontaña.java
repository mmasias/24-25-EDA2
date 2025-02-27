package entregas.lopezMartin.reto002.src;

public class ArrayMontaña {
    
    public static boolean esMontaña1(int[] array) {
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

    public static boolean esMontaña2(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }

        int n = array.length;
        int ascenso = 0;
        int descenso = n - 1;

        while (ascenso + 1 < n && array[ascenso] < array[ascenso + 1]) {
            ascenso++;
        }

        while (descenso > 0 && array[descenso - 1] > array[descenso]) {
            descenso--;
        }

        return ascenso > 0 && descenso < n - 1 && ascenso == descenso;
    }
    
    public static void main(String[] args) {

        int[] array1 = {1, 3, 5, 4, 2};
        System.out.println("¿Es montaña? " + esMontaña2(array1));
        
    }
}
