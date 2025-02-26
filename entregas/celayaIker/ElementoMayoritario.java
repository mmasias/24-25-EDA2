package entregas.celayaIker;

public class ElementoMayoritario {
    public static int encontrarMayoritario(int[] nums) {
        int n = nums.length;
        int candidato = nums[n / 2];

        int primera = buscarPrimeraAparicion(nums, candidato);
        int ultima = buscarUltimaAparicion(nums, candidato);

        if ((ultima - primera + 1) > n / 2) {
            return candidato;
        }

        return -1; 
    }

    private static int buscarPrimeraAparicion(int[] nums, int objetivo) {
        int inicio = 0, fin = nums.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (nums[medio] >= objetivo) {
                fin = medio;
            } else {
                inicio = medio + 1;
            }
        }
        return inicio;
    }

    private static int buscarUltimaAparicion(int[] nums, int objetivo) {
        int inicio = 0, fin = nums.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio + 1) / 2;
            if (nums[medio] <= objetivo) {
                inicio = medio;
            } else {
                fin = medio - 1;
            }
        }
        return inicio;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        int mayoritario = encontrarMayoritario(nums);
        System.out.println("Elemento mayoritario: " + mayoritario);
    }
}
