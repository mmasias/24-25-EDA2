package nivel3;

public class KElementosCercanos {
    public static void main(String[] args) {
        int[] entrada = { 1, 2, 3, 4, 5 };
        int k = 2;
        double target = 3.7;

        int[] resultado = encontrarKElementosCercanos(entrada, k, target);
        for (int i = 0; i < resultado.length; i++) {
            System.out.print(resultado[i] + " ");
        }
    }

    public static int[] encontrarKElementosCercanos(int[] array, int k, double target) {
        int n = array.length;
        int[] resultado = new int[k];
        int[] indicesUsados = new int[k];
        for (int i = 0; i < k; i++) {
            indicesUsados[i] = -1;
        }

        for (int i = 0; i < k; i++) {
            int minIndex = -1;
            double diferenciaMinima = Double.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                boolean yaUsado = false;
                for (int m = 0; m < i; m++) {
                    if (indicesUsados[m] == j) {
                        yaUsado = true;
                        break;
                    }
                }

                if (!yaUsado && Math.abs(array[j] - target) < diferenciaMinima) {
                    diferenciaMinima = Math.abs(array[j] - target);
                    minIndex = j;
                }
            }

            resultado[i] = array[minIndex];
            indicesUsados[i] = minIndex;
        }

        return resultado;
    }
}
