package entregas.celayaIker.Ejercicio1;

class Frame {
    private Pixel[] frame;

    public Frame(int width, int height) {
        frame = new Pixel[width * height];
        for (int i = 0; i < width * height; i++) {
            frame[i] = new Pixel(0); 
        }
    }

    public void modificarPixel(int pos, int nuevoValor) {
        if (pos >= 0 && pos < frame.length) {
            frame[pos].setDato(nuevoValor);
        } else {
            System.out.println("Posición fuera de rango.");
        }
    }

    public Pixel obtenerPixel(int pos) {
        if (pos >= 0 && pos < frame.length) {
            return frame[pos];
        } else {
            System.out.println("Posición fuera de rango.");
            return new Pixel(0);
        }
    }

    public void imprimir() {
        for (int i = 0; i < frame.length; i++) {
            if (i % 320 == 0) System.out.println();
            System.out.print(frame[i].obtenerDato() + " ");
        }
        System.out.println();
    }
}

