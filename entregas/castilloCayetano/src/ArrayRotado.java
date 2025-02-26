public class ArrayRotado{
    //Completado
    public static void main(String[] args) {
        imprimirArrayRotado();
    }
    
    public void mostrar() {
        imprimirArrayRotado();
    }
    public static void imprimirArrayRotado() {
        int[] array = {4, 5, 0, 1, 2, 3};
        int objetivo = 0;
        int indice = encontrarIndice(array, objetivo);
        System.out.println("Indice: " + indice);
    }
    public static int encontrarIndice(int[] array, int objetivo) {
        int inicio = 0;
        int fin = array.length - 1;
        while (inicio <= fin) {
            int medio = (inicio + fin) / 2;
            if (array[medio] == objetivo) {
                return medio;
            }
            if (array[inicio] <= array[medio]) {
                if (objetivo >= array[inicio] && objetivo < array[medio]) {
                    fin = medio - 1;
                } else {
                    inicio = medio + 1;
                }
            } else {
                if (objetivo > array[medio] && objetivo <= array[fin]) {
                    inicio = medio + 1;
                } else {
                    fin = medio - 1;
                }
            }
        }
        return -1;
    }
}