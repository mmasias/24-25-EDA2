package entregas.Reyes_David.Reto_002.Nivel1;

public class PuntoEquilibrio {
    public static int encontrarPuntoEquilibrio(int[] array) {
        int sumaTotal = 0;
        for (int num : array) {
            sumaTotal += num;
        }
        int sumaIzquierda = 0;
        for (int i = 0; i < array.length; i++) {
            sumaTotal -= array[i];
            if (sumaIzquierda == sumaTotal) {
                return i;
            }
            sumaIzquierda += array[i];
        }
        return -1; 
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 6};
        int puntoEquilibrio = encontrarPuntoEquilibrio(array);
        System.out.println("Punto de equilibrio: " + puntoEquilibrio);
    }
}