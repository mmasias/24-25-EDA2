class CasiOrdenado {
    public static void ordenarCasiOrdenado(int[] array, int k) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length && j <= i + k; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] array = {2, 1, 3, 5, 4};
        int k = 2;
        
        ordenarCasiOrdenado(array, k);
        
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
