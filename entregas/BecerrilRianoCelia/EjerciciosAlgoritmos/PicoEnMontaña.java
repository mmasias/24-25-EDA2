package EjerciciosAlgoritmos;

public class PicoEnMontaña {

    public static int encontrarPico(int[] array) {
        int inicio = 0;
        int fin = array.length - 1;

        while (inicio < fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (array[medio] > array[medio + 1]) {
                
                fin = medio;
            } else {
            
                inicio = medio + 1;
            }
        }

       
        return array[inicio];
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 6, 4, 2};
        int resultado = encontrarPico(array);
        System.out.println("El pico en la montaña es: " + resultado);
    }
}