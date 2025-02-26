package entregas.celayaIker;

public class ArrayRotadoDuplicados {
    public static int encontrarPuntoRotacion(int[] nums) {
        int inicio = 0, fin = nums.length - 1;

        while (inicio < fin) {
            int mid = inicio + (fin - inicio) / 2;

            if (nums[mid] > nums[mid + 1]) {
                return mid + 1;
            }

            if (nums[inicio] == nums[mid] && nums[mid] == nums[fin]) {
                inicio++;
                fin--;
            } 
            else if (nums[mid] > nums[fin]) {
                inicio = mid + 1;
            } 
            else {
                fin = mid;
            }
        }

        return inicio; 
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 6, 1, 1, 2, 3, 3};
        int indice = encontrarPuntoRotacion(nums);
        
        System.out.println("Punto de rotación en índice: " + indice);
    }
}
