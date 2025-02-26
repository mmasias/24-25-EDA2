public class ParesDiferenciaOptimizado {
    public static Map<Integer, List<List<Integer>>> encontrarParesMultiples(int[] arr, int[] ks) {
        Map<Integer, List<List<Integer>>> resultados = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int num : arr) set.add(num);

        for (int k : ks) {
            List<List<Integer>> pares = new ArrayList<>();
            for (int num : arr) {
                if (set.contains(num + k)) {
                    pares.add(Arrays.asList(num, num + k));
                }
            }
            resultados.put(k, pares);
        }

        return resultados;
    }

    public static void main(String[] args) {
        int[] arr = {1, 7, 5, 9, 2, 12, 3};
        int[] ks = {2, 4};
        System.out.println(encontrarParesMultiples(arr, ks));
    }
}
