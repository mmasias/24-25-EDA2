import java.util.Arrays;

public class ElementoMayoritario {
    public static int elementoMayoritario(int[] arr) {
        int n = arr.length;
        int medio = n / 2;
        int candidato = arr[medio];

        int izquierda = Arrays.binarySearch(arr, candidato);
        while (izquierda > 0 && arr[izquierda - 1] == candidato) izquierda--;

        int derecha = izquierda;
        while (derecha < n - 1 && arr[derecha + 1] == candidato) derecha++;

        return (derecha - izquierda + 1 > n / 2) ? candidato : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 2, 2, 3};
        System.out.println(elementoMayoritario(arr));
    }
}
