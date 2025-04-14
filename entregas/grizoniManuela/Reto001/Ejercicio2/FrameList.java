package Reto001.Ejercicio2;

public class FrameList {
    private NodoFrame primero;
    private NodoFrame segundo;
    private int tamaño;

    public FrameList() {
        this.primero = null;
        this.segundo = null;
        this.tamaño = 0;
    }

    public void addFrame(Frame frame) {
        NodoFrame nuevo = new NodoFrame(frame);
        if (primero == null) {
            primero = nuevo;
            tamaño++;
        } else if (segundo == null) {
            segundo = nuevo;
            primero.setSiguiente(segundo);
            segundo.setAnterior(primero);
            tamaño++;
        } else {
            System.out.println("Solo se permiten dos frames en esta implementación.");
        }
    }

    public NodoFrame getPrimero() {
        return primero;
    }

    public NodoFrame getSegundo() {
        return segundo;
    }

    public int getTamaño() {
        return tamaño;
    }
}
