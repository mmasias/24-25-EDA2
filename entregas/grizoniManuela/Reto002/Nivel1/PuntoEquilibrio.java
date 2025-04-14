package Reto002.Nivel1;

public class PuntoEquilibrio {
    public static int encontrarIndiceEquilibrio(int[] arr) {
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }
        int sumaIzq = 0;
        for (int i = 0; i < arr.length; i++) {
            if (sumaIzq == total - sumaIzq - arr[i]) {
                return i;
            }
            sumaIzq += arr[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 6};
        int indice = encontrarIndiceEquilibrio(arr);

        StringBuilder sumaIzqStr = new StringBuilder();
        int sumaIzq = 0;
        for (int i = 0; i < indice; i++) {
            sumaIzqStr.append(arr[i]);
            sumaIzq += arr[i];
            if (i < indice - 1) {
                sumaIzqStr.append("+");
            }
        }

        System.out.println("Salida: " + indice + " (" + sumaIzqStr.toString() + " = " + sumaIzq + ")");
    }
}




