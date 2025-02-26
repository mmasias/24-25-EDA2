public class SumaMaxima {

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        System.out.println("La suma de los elementos del arreglo es: " + sumArray(array));
    }

    private static int sumArray(int[] array) {
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            sum += array[i];
        }
        return sum;
    }
}