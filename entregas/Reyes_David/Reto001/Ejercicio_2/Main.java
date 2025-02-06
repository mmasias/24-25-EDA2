package entregas.Reyes_David.Reto001.Ejercicio_2;

public class Main {
    public static void main(String[] args) {
        int filas = 3, columnas = 4;
        DobleBuffer buffer = new DobleBuffer(filas, columnas);
        Pantalla pantalla = new Pantalla();

        System.out.println("Ingrese los colores del Frame 1:");
        buffer.getFrame1().seleccionarColores();
        System.out.println("Ingrese los colores del Frame 2:");
        buffer.getFrame2().seleccionarColores();

        buffer.combinarFrames();
        System.out.println("Frame 1:");
        pantalla.mostrar(buffer.getFrame1());
        System.out.println("Frame 2:");
        pantalla.mostrar(buffer.getFrame2());
        System.out.println("Resultado de la combinación:");
        pantalla.mostrar(buffer.getResultado());
    }
}
