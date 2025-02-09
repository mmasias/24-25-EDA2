package ejercicio1;

public class Frame {
    private Pixel[] frame;

    public Frame(int width, int height) {
        frame = new Pixel[width * height];
        for (int i = 0; i < width * height; i++) {
            frame[i] = new Pixel();
        }
    }

    public void modificarPixel(int pos, int nuevoValor) {
        if (pos >= 0 && pos < frame.length) {
            frame[pos].setDato(nuevoValor);
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    public Pixel[] obtenerFrame() {
        return frame;
    }
}
