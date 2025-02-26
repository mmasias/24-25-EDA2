package entregas.romeroAngel.reto002.Nivel1;

public class EquilibriumPoint {
 
    public static int findEquillibriumPoint(int[] numberArray) {
        int totalSum = 0;
        for (int num : numberArray) {
            totalSum += num;
        }

        int accumulatedSum = 0;

        for (int i = 0; i < numberArray.length; i++) {

            if (accumulatedSum == (totalSum - numberArray[i] - accumulatedSum)) {
                return i; 
            }
            accumulatedSum += numberArray[i]; 
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] numberArray = {1, 2, 3, 4, 6};
        int equillibriumIndex = findEquillibriumPoint(numberArray);
        
        if (equillibriumIndex != -1) {
            System.out.println("El punto de equilibrio está en el índice: " + equillibriumIndex);
        } else {
            System.out.println("No se encontró un punto de equilibrio.");
        }
    }   
}