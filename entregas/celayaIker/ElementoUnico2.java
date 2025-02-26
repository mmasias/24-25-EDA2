package entregas.celayaIker;

public class ElementoUnico2 {
    public static int encontrarUnico(int[] nums) {
        int resultado = 0;

        for (int num : nums) {
            resultado ^= num;
        }

        return resultado; 
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 3, 2};
        int unico = encontrarUnico(nums);
        
        System.out.println("Elemento único: " + unico);
    }
}
