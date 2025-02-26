public class NumeroFaltante {
    public static int encontrarNumeroFaltante(int[] nums) {
        int n = nums.length + 1;
        int sumaTotal = n * (n + 1) / 2;
        int sumaArray = 0;
        
        for (int num : nums) {
            sumaArray += num;
        }
        
        return sumaTotal - sumaArray;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        int faltante = encontrarNumeroFaltante(nums);
        System.out.println("Número faltante: " + faltante);
    }
}