public class MedianaStream {
    private static int[] numeros = new int[1000];
    private static int size = 0;

    public static void agregarNumero(int numero) {
        int i = size - 1;
        while (i >= 0 && numeros[i] > numero) {
            numeros[i + 1] = numeros[i];
            i--;
        }
        numeros[i + 1] = numero;
        size++;
    }

    public static double encontrarMediana() {
        if (size % 2 == 0) {
            return (numeros[size / 2 - 1] + numeros[size / 2]) / 2.0;
        } else {
            return numeros[size / 2];
        }
    }

    public static void main(String[] args) {
        int[] stream = {1, 3, 2, 4, 5};
        for (int numero : stream) {
            agregarNumero(numero);
            System.out.println(encontrarMediana());
        }
    }
}
