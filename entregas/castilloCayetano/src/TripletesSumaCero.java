public class TripletesSumaCero {
    // Completado
    public static void main(String[] args) {
        imprimirTripletesSumaCero();
    }
    public void mostrar(){
        imprimirTripletesSumaCero();
    }
    public static void imprimirTripletesSumaCero(){
        int[] array = {-1, 0, 1, 2, -1, -4};
        boolean existeTriplete = encontrarTriplete(array);
        System.out.println("¿Existe al menos un triplete? " + existeTriplete);
        int count = contarTripletesSumaCero(array);
        System.out.println("Número de tripletes con suma cero: " + count);
    }
    public static boolean encontrarTriplete(int[] array){
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static int contarTripletesSumaCero(int[] array){
        if (array == null || array.length < 3) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] + array[k] == 0) {
                        System.out.println("Triplete con suma cero: (" + array[i] + ", " + array[j] + ", " + array[k] + ")");
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
