package entregas.lopezMartin.reto002.src;

public class ContadorDeInversiones {

    public static int contarParesInvertidos(int[] arr) {
        int n = arr.length;
        int contador = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j]) {
                    contador++;
                    System.out.println("(" + arr[i] + ", " + arr[j] + ")");
                }
            }
        }
        return contador;
    }

    public static void main(String[] args) {
        int[] arr = {2, 4, 1, 3, 5};
        int resultado = contarParesInvertidos(arr);
        System.out.println("Número total de pares en orden incorrecto: " + resultado);
    }
}
