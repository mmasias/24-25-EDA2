package Reto001.Ejercicio1;

public class NodoPixel {
    private NodoPixel anterior;
    private NodoPixel siguiente;
    private Pixel pixel;

    public NodoPixel(Pixel pixel) {
        this.pixel = pixel;
        this.anterior = null;
        this.siguiente = null;
    }

    public NodoPixel getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPixel anterior) {
        this.anterior = anterior;
    }

    public NodoPixel getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoPixel siguiente) {
        this.siguiente = siguiente;
    }

    public Pixel getPixel() {
        return pixel;
    }

    public void setPixel(Pixel pixel) {
        this.pixel = pixel;
    }
}
