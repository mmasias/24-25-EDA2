package entregas.celayaIker.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();

        pantalla.modificarPixel(0, 2, 0, 255);
        pantalla.modificarPixel(0, 4, 1, 128);
        pantalla.modificarPixel(0, 0, 2, 255);

        pantalla.mostrarFrame(0);

        pantalla.modificarPixel(1, 0, 0, 64);
        pantalla.modificarPixel(1, 4, 1, 64);
        pantalla.modificarPixel(1, 2, 2, 64);

        pantalla.mostrarFrame(1);

        pantalla.combinarFrames();
    }
}
