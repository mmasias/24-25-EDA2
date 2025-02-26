package entregas.romeroAngel.reto002.Nivel2;

public class MajorityElement {

    private static int firstOccurrence(int[] numberArray, int element, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            
            if ((mid == 0 || numberArray[mid - 1] < element) && numberArray[mid] == element) {
                return mid;
            }
            
            else if (numberArray[mid] < element) {
                return firstOccurrence(numberArray, element, mid + 1, high);
            }
            
            else {
                return firstOccurrence(numberArray, element, low, mid - 1);
            }
        }
        return -1; 
    }

    private static int lastOccurrence(int[] numberArray, int element, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;

            if ((mid == numberArray.length - 1 || numberArray[mid + 1] > element) && numberArray[mid] == element) {
                return mid;
            }
            
            else if (numberArray[mid] > element) {
                return lastOccurrence(numberArray, element, low, mid - 1);
            }
            
            else {
                return lastOccurrence(numberArray, element, mid + 1, high);
            }
        }
        return -1; 
    }

    public static int findMajorityElement(int[] numberArray) {
        int n = numberArray.length;
        int candidate = numberArray[n / 2]; 

        int first = firstOccurrence(numberArray, candidate, 0, n - 1);
        int last = lastOccurrence(numberArray, candidate, 0, n - 1);

        if (first != -1 && last != -1 && (last - first + 1) > n / 2) {
            return candidate;
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 2, 2, 3};
        int majorityElement = findMajorityElement(array);

        if (majorityElement != -1) {
            System.out.println("El elemento mayoritario es: " + majorityElement);
        } else {
            System.out.println("No hay elemento mayoritario.");
        }
    }
    
}
