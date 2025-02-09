package Reto001.Ejercicio2;

public class NodoPixel {
    private Pixel pixel;
    private NodoPixel siguiente;

    public NodoPixel(Pixel pixel) {
        this.pixel = pixel;
        this.siguiente = null;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }

    public NodoPixel getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPixel siguiente) {
        this.siguiente = siguiente;
    }
}

