class SubconjuntosK {
    public static void generarSubconjuntosK(int[] arr, int k) {
        int n = arr.length;
        int total = 1 << n;
        for (int i = 0; i < total; i++) {
            int count = 0;
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) != 0) {
                    count++;
                }
            }
            if (count == k) {
                System.out.print("[");
                for (int j = 0; j < n; j++) {
                    if ((i & (1 << j)) != 0) {
                        System.out.print(arr[j] + " ");
                    }
                }
                System.out.println("]");
            }
        }
    }

    public static void main(String[] args) {
        int[] entrada = {1, 2, 3};
        int k = 2;
        generarSubconjuntosK(entrada, k);
    }
}
