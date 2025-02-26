package Reto001.Ejercicio1;

public class PixelList {
    private NodoPixel primero;
    private NodoPixel ultimo;
    private int tamaño;

    public PixelList() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public void addPixel(Pixel pixel) {
        NodoPixel nuevo = new NodoPixel(pixel);
        if (primero == null) {
            primero = nuevo;
            ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
        tamaño++;
    }

    public Pixel get(int index) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        NodoPixel actual = primero;
        int contador = 0;
        while (actual != null) {
            if (contador == index) {
                return actual.getPixel();
            }
            contador++;
            actual = actual.getSiguiente();
        }
        return null;
    }

    public void set(int index, Pixel pixel) {
        if (index < 0 || index >= tamaño) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }
        NodoPixel actual = primero;
        int contador = 0;
        while (actual != null) {
            if (contador == index) {
                actual.setPixel(pixel);
                return;
            }
            contador++;
            actual = actual.getSiguiente();
        }
    }

    public int getTamaño() {
        return tamaño;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        NodoPixel actual = primero;
        while (actual != null) {
            sb.append(actual.getPixel().toString());
            if (actual.getSiguiente() != null) {
                sb.append(" -> ");
            }
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }
}
