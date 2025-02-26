public class ArrayRotado {
    public static int encontrarPuntoRotacion(int[] numeros) {
        int inicio = 0, fin = numeros.length - 1;
        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;
            if (numeros[medio] > numeros[fin]) {
                inicio = medio + 1;
            } else {
                fin = medio;
            }
        }
        return inicio;
    }
    
    public static void main(String[] args) {
        int[] numeros = {4, 5, 6, 1, 2, 3};
        System.out.println("Punto de rotación: " + encontrarPuntoRotacion(numeros));
    }
}
