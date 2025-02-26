public class ElementoMayoritario {
    public static int encontrarElementoMayoritario(int[] array) {
        int n = array.length;
        int candidato = array[n / 2]; 
        int contador = 0;


        for (int num : array) {
            if (num == candidato) {
                contador++;
            }
        }

        if (contador > n / 2) {
            return candidato;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 1, 1, 1, 2, 2, 3};
        int elemento = encontrarElementoMayoritario(array);
        System.out.println("Elemento mayoritario: " + elemento);
    }
}