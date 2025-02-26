public class CasiOrdenado {
    //Completado
    public static void main(String[] args) {
        imprimirCasiOrdenado();
    }
    public void mostrar(){
        imprimirCasiOrdenado();
    }

    public static void imprimirCasiOrdenado() {
        int[] array = {2, 1, 3, 5, 4};
        int k = 2;
        ordenarCasiOrdenado(array, k);
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(",");
            }
        }
        System.out.println("]");
    }

    public static void ordenarCasiOrdenado(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && j > i - k && array[j - 1] > temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }
}