package entregas.PinedaOscar.Reto_002.Nivel2;

public class picoMontana {
    public static int encontrarPico(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;

        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (array[medio] < array[medio + 1]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        } 

        return array[izquierda];
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 5, 7, 6, 4, 2};
        int pico = encontrarPico(array);
        System.out.println("Pico en la montaña: " + pico);
    }    
}
