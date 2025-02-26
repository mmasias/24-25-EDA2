public class ElementoMayoritario {
    public static void main(String[] args) {
        int[] array = { 1, 1, 1, 1, 2, 2, 3 };
        int resultado = encontrarElementoMayoritario(array);
        System.out.println("Elemento mayoritario: " + resultado);
    }

    public static int encontrarElementoMayoritario(int[] nums) {

        int candidato = nums[nums.length / 2];

        int primerIndice = buscarPrimerIndice(nums, candidato);

        int ultimoIndice = buscarUltimoIndice(nums, candidato);

        int frecuencia = ultimoIndice - primerIndice + 1;

        if (frecuencia > nums.length / 2) {
            return candidato;
        }

        return -1;
    }

    private static int buscarPrimerIndice(int[] nums, int valor) {
        int izquierda = 0;
        int derecha = nums.length - 1;
        int resultado = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (nums[medio] == valor) {
                resultado = medio;
                derecha = medio - 1;
            } else if (nums[medio] < valor) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return resultado;
    }

    private static int buscarUltimoIndice(int[] nums, int valor) {
        int izquierda = 0;
        int derecha = nums.length - 1;
        int resultado = -1;

        while (izquierda <= derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;

            if (nums[medio] == valor) {
                resultado = medio;
                izquierda = medio + 1;
            } else if (nums[medio] < valor) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }

        return resultado;
    }
}