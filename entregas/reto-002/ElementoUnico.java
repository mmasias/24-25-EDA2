public class ElementoUnico {

    public static int encontrarElementoUnico(int[] arr) {
        int resultado = 0;

        for (int num : arr) {
            resultado ^= num;
        }

        return resultado;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, 1, 3, 2 };
        int elementoUnico = encontrarElementoUnico(arr);
        System.out.println("El elemento único es: " + elementoUnico);
    }
}