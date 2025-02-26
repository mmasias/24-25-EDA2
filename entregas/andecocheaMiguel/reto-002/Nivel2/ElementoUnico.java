public class ElementoUnico {
    public static int encontrarElementoUnico(int[] numeros) {
        int resultado = 0;
        for (int num : numeros) {
            resultado ^= num;
        }
        return resultado;
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 1, 3, 2};
        System.out.println("Elemento único: " + encontrarElementoUnico(numeros));
    }
}