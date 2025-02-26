public class TriangulosPosibles {
    public static void main(String[] args) {
        int[] numeros = { 3, 4, 5, 6, 7 };
        boolean resultado = verificarTrianguloPosible(numeros);

        if (resultado) {
            int[] triplete = encontrarTriplete(numeros);
            System.out.println("Resultado: true (" + triplete[0] + "," + triplete[1] + "," + triplete[2] + ")");
        } else {
            System.out.println("Resultado: false");
        }
    }

    public static boolean verificarTrianguloPosible(int[] nums) {
        int n = nums.length;

        if (n < 3) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (esTriangulo(nums[i], nums[j], nums[k])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static int[] encontrarTriplete(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (esTriangulo(nums[i], nums[j], nums[k])) {
                        return new int[] { nums[i], nums[j], nums[k] };
                    }
                }
            }
        }

        return new int[0];
    }

    private static boolean esTriangulo(int a, int b, int c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }
}