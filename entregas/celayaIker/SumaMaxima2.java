package entregas.celayaIker;

public class SumaMaxima2 {
    public static int[] encontrarSubarregloMaximo(int[] nums) {
        return encontrarMaximo(nums, 0, nums.length - 1);
    }

    private static int[] encontrarMaximo(int[] nums, int izquierda, int derecha) {
        if (izquierda == derecha) { 
            return new int[]{nums[izquierda], izquierda, derecha};
        }

        int medio = izquierda + (derecha - izquierda) / 2;

        int[] izqMax = encontrarMaximo(nums, izquierda, medio);
        int[] derMax = encontrarMaximo(nums, medio + 1, derecha);
        int[] cruzMax = encontrarMaximoCruzado(nums, izquierda, medio, derecha);

        if (izqMax[0] >= derMax[0] && izqMax[0] >= cruzMax[0]) {
            return izqMax;
        } else if (derMax[0] >= izqMax[0] && derMax[0] >= cruzMax[0]) {
            return derMax;
        } else {
            return cruzMax;
        }
    }

    private static int[] encontrarMaximoCruzado(int[] nums, int izquierda, int medio, int derecha) {
        int sumaIzquierda = Integer.MIN_VALUE, suma = 0, maxIzquierda = medio;
        for (int i = medio; i >= izquierda; i--) {
            suma += nums[i];
            if (suma > sumaIzquierda) {
                sumaIzquierda = suma;
                maxIzquierda = i;
            }
        }

        int sumaDerecha = Integer.MIN_VALUE;
        suma = 0;
        int maxDerecha = medio + 1;
        for (int i = medio + 1; i <= derecha; i++) {
            suma += nums[i];
            if (suma > sumaDerecha) {
                sumaDerecha = suma;
                maxDerecha = i;
            }
        }

        return new int[]{sumaIzquierda + sumaDerecha, maxIzquierda, maxDerecha};
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] resultado = encontrarSubarregloMaximo(nums);

        System.out.print("Subarreglo con suma máxima: [");
        for (int i = resultado[1]; i <= resultado[2]; i++) {
            System.out.print(nums[i] + (i < resultado[2] ? ", " : ""));
        }
        System.out.println("]");
    }
}

