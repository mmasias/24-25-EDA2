package Reto001.Ejercicio2;

public class PixelList {
    private NodoPixel primero;
    private NodoPixel ultimo;

    public PixelList() {
        this.primero = null;
        this.ultimo = null;
    }

    public void addPixel(Pixel pixel) {
        NodoPixel nuevo = new NodoPixel(pixel);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            ultimo = nuevo;
        }
    }

    public void updateAllPixels(char newValue) {
        NodoPixel actual = primero;
        while (actual != null) {
            actual.getPixel().setResultado(newValue);
            actual = actual.getSiguiente();
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoPixel actual = primero;
        while (actual != null) {
            sb.append(actual.getPixel().getResultado()).append(" ");
            actual = actual.getSiguiente();
        }
        return sb.toString().trim();
    }
}

