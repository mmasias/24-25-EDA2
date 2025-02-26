public class SumaMaxima {
    public static void encontrarSubarregloMaximo(int[] nums) {
        int maxSuma = nums[0];
        int sumaActual = nums[0];
        int inicio = 0, fin = 0;
        int tempInicio = 0;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > sumaActual + nums[i]) {
                sumaActual = nums[i];
                tempInicio = i;
            } else {
                sumaActual += nums[i];
            }

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        System.out.print("Subarreglo con suma máxima: ");
        for (int i = inicio; i <= fin; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        encontrarSubarregloMaximo(nums);
    }
}