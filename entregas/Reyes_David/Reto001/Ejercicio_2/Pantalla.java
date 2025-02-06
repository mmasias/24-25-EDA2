package entregas.Reyes_David.Reto001.Ejercicio_2;

public class Pantalla {
    public void mostrar(Frame frame) {
        for (Pixel[] fila : frame.getMatriz()) {
            for (Pixel pixel : fila) {
                System.out.print(pixel.getColor() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}