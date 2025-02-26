class Permutaciones {
    public static void generarPermutaciones(char[] str, int l, int r) {
        if (l == r) {
            System.out.println(new String(str));
            return;
        }
        for (int i = l; i <= r; i++) {
            intercambiar(str, l, i);
            generarPermutaciones(str, l + 1, r);
            intercambiar(str, l, i);
        }
    }

    private static void intercambiar(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        char[] entrada = {'a', 'b', 'c'};
        generarPermutaciones(entrada, 0, entrada.length - 1);
    }
}
