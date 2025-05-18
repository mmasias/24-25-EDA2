package entregas.PinedaOscar.Reto_002.Nivel2;

public class Arrayrotado {
    public static int encontrarPuntoRotacion(int[] array) {
        int izquierda = 0;
        int derecha = array.length - 1;

        while (izquierda < derecha) {
            int medio = izquierda + (derecha - izquierda) / 2;
            if (array[medio] > array[derecha]) {
                izquierda = medio + 1;
            } else {
                derecha = medio;
            }
        }

        return izquierda;
    }

    public static void main(String[] args) {
        int[] array = { 4, 5, 6, 1, 2, 3 };
        int puntoRotacion = encontrarPuntoRotacion(array);
        System.out.println("Punto de rotación: " + puntoRotacion);
    }
    
}
