package entregas.celayaIker.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();

        pantalla.modificarPixel(2, 0, 255);
        pantalla.modificarPixel(4, 0, 255);
        pantalla.modificarPixel(1, 1, 128);
        pantalla.modificarPixel(3, 1, 128);
        pantalla.modificarPixel(0, 2, 255);
        pantalla.modificarPixel(1, 2, 255);
        pantalla.modificarPixel(2, 2, 255);

        System.out.println("Estado del Frame 1:");
        pantalla.mostrarFrame(0);

        pantalla.alternarFrames();

        pantalla.modificarPixel(0, 0, 128);
        pantalla.modificarPixel(6, 2, 255);

        System.out.println("Estado del Frame 2:");
        pantalla.mostrarFrame(1);

        System.out.println("Estado combinado:");
        pantalla.combinarFrames();
    }
}
