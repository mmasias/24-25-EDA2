package nivel2;

public class ElementoÚnico {
    public static void main(String[] args) {
        int[] entrada = { 1, 2, 1, 3, 2 };
        int elementoUnico = encontrarElementoUnico(entrada);
        System.out.println("El elemento único es: " + elementoUnico);
    }

    public static int encontrarElementoUnico(int[] entrada) {
        int resultado = 0;
        for (int num : entrada) {
            resultado ^= num;
        }
        return resultado;
    }
}
