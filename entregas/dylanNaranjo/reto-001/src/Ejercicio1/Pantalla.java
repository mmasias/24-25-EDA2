package Ejercicio1;

public class Pantalla {
    private Buffer buffer;

    public Pantalla(Frame frame1, Frame frame2) {
        this.buffer = new Buffer(frame1, frame2);
    }

    public void mostrarFrames() {
        Resultado resultado = new Resultado();
        buffer.mostrarFrameElegido(resultado);
    }

    public static void main(String[] args) {
        Frame frame1 = new Frame(7, 3);
        Frame frame2 = new Frame(7, 3);

        frame1.setPixel(3, 0, '#');
        frame1.setPixel(4, 0, '#');
        frame1.setPixel(0, 1, '+');
        frame1.setPixel(1, 1, '+');
        frame1.setPixel(0, 2, '#');
        frame1.setPixel(1, 2, '#');
        frame1.setPixel(2, 2, '#');

        frame2.setPixel(1, 0, '#');
        frame2.setPixel(2, 0, '#');
        frame2.setPixel(2, 1, '+');
        frame2.setPixel(3, 1, '+');
        frame2.setPixel(2, 2, '#');
        frame2.setPixel(3, 2, '#');
        frame2.setPixel(4, 2, '#');

        Pantalla pantalla = new Pantalla(frame1, frame2);
        pantalla.mostrarFrames();
    }
}
