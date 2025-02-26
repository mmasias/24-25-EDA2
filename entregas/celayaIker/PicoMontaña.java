package entregas.celayaIker;

public class PicoMontaña {
    public static int encontrarPico(int[] nums) {
        int inicio = 0, fin = nums.length - 1;

        while (inicio < fin) {
            int mid = inicio + (fin - inicio) / 2;

            if (nums[mid] > nums[mid + 1]) {
                fin = mid; 
            } else {
                inicio = mid + 1; 
            }
        }

        return nums[inicio]; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 7, 6, 4, 2};
        int pico = encontrarPico(nums);
        
        System.out.println("Elemento pico: " + pico);
    }
}
