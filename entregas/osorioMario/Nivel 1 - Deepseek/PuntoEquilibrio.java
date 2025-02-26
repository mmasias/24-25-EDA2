public class PuntoEquilibrio {
    public static int encontrarPuntoEquilibrio(int[] numeros) {
        int sumaTotal = 0;
        for (int num : numeros) {
            sumaTotal += num;
        }
        int sumaIzquierda = 0;
        for (int i = 0; i < numeros.length; i++) {
            int sumaDerecha = sumaTotal - sumaIzquierda - numeros[i];
            if (sumaIzquierda == sumaDerecha) {
                return i;
            }
            sumaIzquierda += numeros[i];
        }
        return -1; // Si no se encuentra
    }

    public static void main(String[] args) {
        int[] numeros = {1, 2, 3, 4, 6};
        int punto = encontrarPuntoEquilibrio(numeros);
        System.out.println("Punto de equilibrio: " + punto);
    }
}