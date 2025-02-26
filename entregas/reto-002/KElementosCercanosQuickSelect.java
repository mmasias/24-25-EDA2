public class KElementosCercanosQuickSelect {
    public static void main(String[] args) {
        int[] numeros = { 1, 2, 3, 4, 5 };
        int k = 2;
        double target = 3.7;

        int[] resultado = encontrarKMasCercanos(numeros, k, target);

        System.out.print("K elementos más cercanos: ");
        for (int num : resultado) {
            System.out.print(num + " ");
        }
    }

    public static int[] encontrarKMasCercanos(int[] nums, int k, double target) {

        Element[] elementos = new Element[nums.length];

        for (int i = 0; i < nums.length; i++) {
            double distancia = Math.abs(nums[i] - target);
            elementos[i] = new Element(nums[i], distancia);
        }

        quickSelect(elementos, 0, nums.length - 1, k - 1);

        int[] resultado = new int[k];
        for (int i = 0; i < k; i++) {
            resultado[i] = elementos[i].valor;
        }

        for (int i = 0; i < k; i++) {
            for (int j = i + 1; j < k; j++) {
                if (resultado[i] > resultado[j]) {
                    int temp = resultado[i];
                    resultado[i] = resultado[j];
                    resultado[j] = temp;
                }
            }
        }

        return resultado;
    }

    private static void quickSelect(Element[] elementos, int inicio, int fin, int k) {
        if (inicio < fin) {
            int pivotIndex = particion(elementos, inicio, fin);

            if (pivotIndex == k) {
                return;
            } else if (pivotIndex < k) {
                quickSelect(elementos, pivotIndex + 1, fin, k);
            } else {
                quickSelect(elementos, inicio, pivotIndex - 1, k);
            }
        }
    }

    private static int particion(Element[] elementos, int inicio, int fin) {
        double pivot = elementos[fin].distancia;
        int i = inicio;

        for (int j = inicio; j < fin; j++) {
            if (elementos[j].distancia <= pivot) {
                Element temp = elementos[i];
                elementos[i] = elementos[j];
                elementos[j] = temp;
                i++;
            }
        }

        Element temp = elementos[i];
        elementos[i] = elementos[fin];
        elementos[fin] = temp;

        return i;
    }

    static class Element {
        int valor;
        double distancia;

        public Element(int valor, double distancia) {
            this.valor = valor;
            this.distancia = distancia;
        }
    }
}