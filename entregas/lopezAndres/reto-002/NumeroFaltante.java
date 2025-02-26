public class NumeroFaltante {
    public static int encontrarFaltante(int[] nums) {
        int n = nums.length + 1;
        int sumaEsperada = (n * (n + 1)) / 2;
        int sumaReal = 0;
        for (int num : nums) {
            sumaReal += num;
        }
        return sumaEsperada - sumaReal;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 5, 6};
        System.out.println("Número faltante: " + encontrarFaltante(nums));
    }
}
