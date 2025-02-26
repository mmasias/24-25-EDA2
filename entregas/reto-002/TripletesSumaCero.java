public class TripletesSumaCero {
    public static void main(String[] args) {
        int[] numeros = { -1, 0, 1, 2, -1, -4 };
        int[][] resultado = encontrarTripletes(numeros);

        System.out.println("Tripletes que suman cero:");
        for (int[] triplete : resultado) {
            System.out.println("[" + triplete[0] + "," + triplete[1] + "," + triplete[2] + "]");
        }
    }

    public static int[][] encontrarTripletes(int[] nums) {
        int n = nums.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        if (!esDuplicado(nums[i], nums[j], nums[k], count, new int[10][3])) {
                            count++;
                        }
                    }
                }
            }
        }

        int[][] resultados = new int[count][3];
        count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        int[] triplete = { nums[i], nums[j], nums[k] };
                        ordenarTriplete(triplete);

                        if (!esDuplicado(triplete[0], triplete[1], triplete[2], count, resultados)) {
                            resultados[count][0] = triplete[0];
                            resultados[count][1] = triplete[1];
                            resultados[count][2] = triplete[2];
                            count++;
                        }
                    }
                }
            }
        }

        return resultados;
    }

    private static void ordenarTriplete(int[] triplete) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (triplete[i] > triplete[j]) {
                    int temp = triplete[i];
                    triplete[i] = triplete[j];
                    triplete[j] = temp;
                }
            }
        }
    }

    private static boolean esDuplicado(int a, int b, int c, int count, int[][] resultados) {
        for (int i = 0; i < count; i++) {
            if (resultados[i][0] == a && resultados[i][1] == b && resultados[i][2] == c) {
                return true;
            }
        }
        return false;
    }
}