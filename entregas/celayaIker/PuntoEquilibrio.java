package entregas.celayaIker;

public class PuntoEquilibrio {
    public static int encontrarPuntoEquilibrio(int[] nums) {
        int sumaTotal = 0, sumaIzq = 0;

        for (int num : nums) {
            sumaTotal += num;
        }

        for (int i = 0; i < nums.length; i++) {

            if (sumaIzq == (sumaTotal - sumaIzq - nums[i])) {
                return i;
            }
            sumaIzq += nums[i]; 
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6}; 
        int indice = encontrarPuntoEquilibrio(nums);
        
        System.out.println("Índice de equilibrio: " + indice);
    }
}
