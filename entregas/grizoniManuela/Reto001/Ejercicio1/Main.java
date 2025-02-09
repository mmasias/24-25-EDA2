package Reto001.Ejercicio1;

// Clase principal para probar la implementación
public class Main {
    public static void main(String[] args) {
        // Crear dos frames con dimensiones y llenarlos con algunos píxeles
        Frame frame1 = new Frame(3, 3);
        frame1.getPixelList().addPixel(new Pixel('A'));
        frame1.getPixelList().addPixel(new Pixel('B'));
        frame1.getPixelList().addPixel(new Pixel('C'));

        Frame frame2 = new Frame(3, 3);
        frame2.getPixelList().addPixel(new Pixel('X'));
        frame2.getPixelList().addPixel(new Pixel('Y'));
        frame2.getPixelList().addPixel(new Pixel('Z'));

        // Crear la lista de frames y agregar los dos frames
        FrameList frameList = new FrameList();
        frameList.addFrame(frame1);
        frameList.addFrame(frame2);

        // Crear la pantalla con la lista de frames
        Pantalla pantalla = new Pantalla(frameList);

        // Mostrar el frame actual
        pantalla.MostrarFrameListActual();

        // Alternar de frame y mostrar el nuevo frame actual
        pantalla.AlternarFrame();
        pantalla.MostrarFrameListActual();

        // Mostrar el frame siguiente (el que no es actual)
        pantalla.MostrarFrameListSiguiente();
    }
}
