package entregas.celayaIker.Ejercicio1;

public class Main {
    public static void main(String[] args) {

        Pantalla pantalla = new Pantalla(3, 5);
        Frame f1 = pantalla.generarFrame();
        f1.modificarPixel(0, 10);
        f1.modificarPixel(1, 20);

        Frame f2 = pantalla.generarFrame();
        f2.modificarPixel(0, 30);
        f2.modificarPixel(1, 40);

        pantalla.addFrame(f1);
        pantalla.addFrame(f2);

        pantalla.mostrarFrame(0);
        pantalla.mostrarFrame(1);

        Pixel nuevoPixel = new Pixel(100);
        f1.traducir(nuevoPixel);
        pantalla.mostrarFrame(0);
    }
}
