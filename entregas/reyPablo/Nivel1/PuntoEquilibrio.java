public class PuntoEquilibrio {
    public static int findEquilibrium(int[] nums) {
        int sumaTotal = 0;
        for (int num : nums) sumaTotal += num;
        int sumaIzquierda = 0;
        for (int i = 0; i < nums.length; i++) {
            int sumaDerecha = sumaTotal - sumaIzquierda - nums[i];
            if (sumaIzquierda == sumaDerecha) return i;
            sumaIzquierda += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] entrada = {1, 2, 3, 4, 6};
        System.out.println(findEquilibrium(entrada));
    }
}