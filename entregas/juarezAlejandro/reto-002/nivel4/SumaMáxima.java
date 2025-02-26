package nivel4;

public class SumaMáxima {
    public static void main(String[] args) {
        int[] entrada = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        int[] resultado = encontrarSubarregloMaximo(entrada);
        System.out.print("Salida: [");
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i]);
            if (i < resultado.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public static int[] encontrarSubarregloMaximo(int[] nums) {
        int maxSuma = nums[0];
        int sumaActual = nums[0];
        int inicio = 0;
        int fin = 0;
        int tempInicio = 0;

        for (int i = 1; i < nums.length; i++) {
            if (sumaActual + nums[i] > nums[i]) {
                sumaActual += nums[i];
            } else {
                sumaActual = nums[i];
                tempInicio = i;
            }

            if (sumaActual > maxSuma) {
                maxSuma = sumaActual;
                inicio = tempInicio;
                fin = i;
            }
        }

        int[] subarregloMaximo = new int[fin - inicio + 1];
        for (int i = inicio; i <= fin; i++) {
            subarregloMaximo[i - inicio] = nums[i];
        }

        return subarregloMaximo;
    }
}
