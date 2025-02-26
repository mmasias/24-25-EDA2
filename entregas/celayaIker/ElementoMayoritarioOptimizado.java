package entregas.celayaIker;

public class ElementoMayoritarioOptimizado {
    public static int encontrarMayoritario(int[] nums) {
        int n = nums.length;
        int candidato = nums[n / 2]; 

        int primera = buscarExtremo(nums, candidato, true);
        int ultima = buscarExtremo(nums, candidato, false);

        if ((ultima - primera + 1) > n / 2) {
            return candidato;
        }

        return -1; 
    }

    private static int buscarExtremo(int[] nums, int objetivo, boolean buscarPrimera) {
        int inicio = 0, fin = nums.length - 1, resultado = -1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (nums[medio] == objetivo) {
                resultado = medio; 
                if (buscarPrimera) {
                    fin = medio - 1; 
                } else {
                    inicio = medio + 1;
                }
            } else if (nums[medio] < objetivo) {
                inicio = medio + 1;
            } else {
                fin = medio - 1;
            }
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3};
        int mayoritario = encontrarMayoritario(nums);
        System.out.println("Elemento mayoritario: " + mayoritario);
    }
}
