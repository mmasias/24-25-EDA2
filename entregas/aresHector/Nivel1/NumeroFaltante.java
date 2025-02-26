public class NumeroFaltante {
    public static int numeroFaltante(int[] arr) {
        int n = arr.length + 1;
        int sumaEsperada = n * (n + 1) / 2;
        int sumaReal = 0;
        for (int num : arr) {
            sumaReal += num;
        }
        return sumaEsperada - sumaReal;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6};
        System.out.println(numeroFaltante(arr)); // Output: 3
    }
}
