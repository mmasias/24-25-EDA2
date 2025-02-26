package entregas.celayaIker;

public class SumaMaxima {
    public static void encontrarSubarregloMaximo(int[] nums) {
        int n = nums.length;
        int suma_maxima = Integer.MIN_VALUE;
        int suma_actual = 0;
        int inicio = 0, fin = 0, inicio_temp = 0;

        for (int i = 0; i < n; i++) {
            suma_actual += nums[i];

            if (suma_actual > suma_maxima) {
                suma_maxima = suma_actual;
                inicio = inicio_temp;
                fin = i;
            }

            if (suma_actual < 0) {
                suma_actual = 0;
                inicio_temp = i + 1;
            }
        }

        System.out.print("Subarreglo con suma máxima: [");
        for (int i = inicio; i <= fin; i++) {
            System.out.print(nums[i] + (i < fin ? ", " : ""));
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        encontrarSubarregloMaximo(nums);
    }
}
