public class SubconjuntosDeTamañoK {
    public static void generarSubconjuntosK(int[] arr, int index, List<Integer> temp, List<List<Integer>> resultado, int k) {
        if (temp.size() == k) {
            resultado.add(new ArrayList<>(temp));
            return;
        }
        if (index == arr.length) return;

        
        generarSubconjuntosK(arr, index + 1, temp, resultado, k);

        
        temp.add(arr[index]);
        generarSubconjuntosK(arr, index + 1, temp, resultado, k);
        temp.remove(temp.size() - 1);
    }

    public static List<List<Integer>> obtenerSubconjuntosK(int[] arr, int k) {
        List<List<Integer>> resultado = new ArrayList<>();
        generarSubconjuntosK(arr, 0, new ArrayList<>(), resultado, k);
        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        int k = 2;
        System.out.println(obtenerSubconjuntosK(arr, k));
    }
}
