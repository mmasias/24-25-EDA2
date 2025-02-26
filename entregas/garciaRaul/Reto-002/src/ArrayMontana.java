public class ArrayMontana {

    public static boolean esMontana(int[] array) {
        if (array.length < 3) {
            return false;
        }
        
        int i = 0;
        
        while (i + 1 < array.length && array[i] < array[i + 1]) {
            i++;
        }
        
        if (i == 0 || i == array.length - 1) {
            return false;
        }
        
        while (i + 1 < array.length && array[i] > array[i + 1]) {
            i++;
        }

        return i == array.length - 1;
    }
    
    public static boolean esMontanaFases(int[] array) {
        if (array.length < 3) {
            return false;
        }
        
        int fase = 0;
        
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                if (fase == 0) {
                    fase = 1;
                } else if (fase == 2) {
                    return false;
                }
            } else if (array[i] < array[i - 1]) {
                // Estamos bajando
                if (fase == 0) {
                    return false;
                } else {
                    fase = 2;
                }
            } else {
                return false;
            }
        }

        return fase == 2;
    }
    
    public static void main(String[] args) {
        int[] montanaValida = {1, 3, 5, 4, 2};
        int[] montanaInvalida1 = {1, 3, 2, 4, 2};
        int[] montanaInvalida2 = {5, 4, 3, 2, 1};
        
        System.out.println("Montaña válida (solución 1): " + esMontana(montanaValida));
        System.out.println("Montaña inválida 1 (solución 1): " + esMontana(montanaInvalida1));
        System.out.println("Montaña inválida 2 (solución 1): " + esMontana(montanaInvalida2));
        
        System.out.println("\nMontaña válida (solución 2): " + esMontanaFases(montanaValida));
        System.out.println("Montaña inválida 1 (solución 2): " + esMontanaFases(montanaInvalida1));
        System.out.println("Montaña inválida 2 (solución 2): " + esMontanaFases(montanaInvalida2));
    }
}