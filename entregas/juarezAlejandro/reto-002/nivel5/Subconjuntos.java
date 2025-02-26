package nivel5;

public class Subconjuntos {
    public static void main(String[] args) {
        int[] entrada = { 1, 2, 3 };
        subconjuntos(entrada, 0, new int[0]);
    }

    public static void subconjuntos(int[] numeros, int index, int[] actual) {
        if (index == numeros.length) {
            imprimirArray(actual);
        } else {
            subconjuntos(numeros, index + 1, actual);

            int[] newCurrent = new int[actual.length + 1];
            for (int i = 0; i < actual.length; i++) {
                newCurrent[i] = actual[i];
            }
            newCurrent[actual.length] = numeros[index];
            subconjuntos(numeros, index + 1, newCurrent);
        }
    }

    public static void imprimirArray(int[] array) {
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}