package entregas.celayaIker;

public class PuntoEquilibrioOptimizado {
    public static int encontrarPuntoEquilibrio(int[] nums) {
        int sumaDerecha = 0, sumaIzquierda = 0;

        for (int num : nums) {
            sumaDerecha += num;
        }

        for (int i = 0; i < nums.length; i++) {
            sumaDerecha -= nums[i]; 

            if (sumaIzquierda == sumaDerecha) {
                return i; 
            }

            sumaIzquierda += nums[i];
        }

        return -1; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 6}; 
        int indice = encontrarPuntoEquilibrio(nums);
        
        System.out.println("Índice de equilibrio: " + indice);
    }
}

