package entregas.romeroAngel.reto002.Nivel1;

public class MissingNumber {

    public static int findMissingNumber(int[] numberArray) {
        int n = numberArray.length + 1; 
        int awaitedSum = n * (n + 1) / 2; 
        int realSum = 0;

        for (int num : numberArray) {
            realSum += num;
        }

        return awaitedSum - realSum;
    }

    public static void main(String[] args) {
        int[] numberArray = {1, 2, 4, 5, 6};
        int missingNumber = findMissingNumber(numberArray);
        
        System.out.println("El número faltante es: " + missingNumber);
    }
}