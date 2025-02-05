package entregas.celayaIker.Ejercicio2;

class Frame {
    private Pixel[] frame;

    public Frame(int size) {
        this.frame = new Pixel[size];
        for (int i = 0; i < size; i++) {
            this.frame[i] = new Pixel(0);
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
