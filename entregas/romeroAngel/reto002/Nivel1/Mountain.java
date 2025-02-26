package entregas.romeroAngel.reto002.Nivel1;

public class Mountain {
    
    public static boolean isMountain(int[] numberArray) {
        if (numberArray.length < 3) {
            return false; 
        }

        int i = 0;

        // Fase creciente
        while (i < numberArray.length - 1 && numberArray[i] < numberArray[i + 1]) {
            i++;
        }

        if (i == 0 || i == numberArray.length - 1) {
            return false;
        }

        while (i < numberArray.length - 1 && numberArray[i] > numberArray[i + 1]) {
            i++;
        }

        return i == numberArray.length - 1;
    }

    public static void main(String[] args) {
        int[] numberArray = {1, 3, 5, 4, 2};
        boolean result = isMountain(numberArray);
        
        System.out.println("¿Es montaña? " + result);
    }
    
}