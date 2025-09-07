package Reto001.Ejercicio1;

public class Main {
    public static void main(String[] args) {
        Frame frame1 = new Frame(3, 3);
        frame1.getPixelList().addPixel(new Pixel('A'));
        frame1.getPixelList().addPixel(new Pixel('B'));
        frame1.getPixelList().addPixel(new Pixel('C'));

        Frame frame2 = new Frame(3, 3);
        frame2.getPixelList().addPixel(new Pixel('X'));
        frame2.getPixelList().addPixel(new Pixel('Y'));
        frame2.getPixelList().addPixel(new Pixel('Z'));

        FrameList frameList = new FrameList();
        frameList.addFrame(frame1);
        frameList.addFrame(frame2);

        Pantalla pantalla = new Pantalla(frameList);

        pantalla.MostrarFrameListActual();

        pantalla.AlternarFrame();
        pantalla.MostrarFrameListActual();

        pantalla.MostrarFrameListSiguiente();
    }
}
