package Reto001.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        PixelList pixelList1 = new PixelList();
        pixelList1.addPixel(new Pixel('W'));
        pixelList1.addPixel(new Pixel('X'));
        pixelList1.addPixel(new Pixel('Y'));

        Frame frame1 = new Frame(10, 20, pixelList1);

        PixelList pixelList2 = new PixelList();
        pixelList2.addPixel(new Pixel('A'));
        pixelList2.addPixel(new Pixel('B'));
        pixelList2.addPixel(new Pixel('C'));

        Frame frame2 = new Frame(15, 25, pixelList2);

        FrameList frameList = new FrameList();
        frameList.addFrame(frame1);
        frameList.addFrame(frame2);

        Pantalla pantalla = new Pantalla(frameList);

        pantalla.MostrarColorBlanco();   
        pantalla.MostrarColorNegro();    
        pantalla.AlternarFrame();       
        pantalla.MostrarColorCyan();     
        pantalla.MostrarColorMagenta(); 
        pantalla.AlterarColor();         
        pantalla.MostrarFrameListSiguiente(); 
    }
}
