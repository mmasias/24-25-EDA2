package entregas.celayaIker.Ejercicio1;

class Frame {
    private Pixel[] frame;

    public Frame(int width, int height) {
        frame = new Pixel[width * height];
        for (int i = 0; i < width * height; i++) {
            frame[i] = new Pixel(i);
        }
    }

    public void modificarPixel(int pos, int nuevoValor) {
        if (pos >= 0 && pos < frame.length) {
            frame[pos].setDato(nuevoValor);
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    public void traducir(Pixel pixel) {
        for (Pixel p : frame) {
            p.setDato(pixel.obtenerDato());
        }
    }

    public void imprimir() {
        for (Pixel p : frame) {
            System.out.print(p.obtenerDato() + " ");
        }
        System.out.println();
    }

    public Pixel[] obtenerFrame() {
        return frame;
    }
}
