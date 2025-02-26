package entregas.celayaIker;

public class Mediana {
    public static void insertarOrdenado(int[] nums, int n, int nuevo) {
        int i = n - 1;
        while (i >= 0 && nums[i] > nuevo) {
            nums[i + 1] = nums[i]; 
            i--;
        }
        nums[i + 1] = nuevo; 
    }

    public static double calcularMediana(int[] nums, int n) {
        if (n % 2 == 1) {
            return nums[n / 2]; 
        } else {
            return (nums[n / 2 - 1] + nums[n / 2]) / 2.0; 
        }
    }

    public static void main(String[] args) {
        int[] flujo = {1, 3, 2, 4, 5};
        int[] nums = new int[flujo.length]; 
        int n = 0;

        System.out.print("Medianas en stream: ");
        for (int num : flujo) {
            insertarOrdenado(nums, n, num); 
            n++;
            System.out.print(calcularMediana(nums, n) + " ");
        }
    }
}
