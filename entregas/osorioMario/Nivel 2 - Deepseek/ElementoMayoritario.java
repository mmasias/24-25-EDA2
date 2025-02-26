public class ElementoMayoritario {
    public static int encontrarMayoritario(int[] numeros) {
        return numeros[numeros.length / 2];
    }

    public static void main(String[] args) {
        int[] numeros = {1, 1, 1, 1, 2, 2, 3};
        int mayoritario = encontrarMayoritario(numeros);
        System.out.println("Elemento mayoritario: " + mayoritario);
    }
}