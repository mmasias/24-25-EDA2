public class ElementoUnico {
    public static int encontrarUnico(int[] numeros) {
        int unico = 0;
        for (int num : numeros) {
            unico ^= num;
        }
        return unico;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 1, 3, 2};
        int unico = encontrarUnico(numeros);
        System.out.println("Elemento único: " + unico);
    }
}