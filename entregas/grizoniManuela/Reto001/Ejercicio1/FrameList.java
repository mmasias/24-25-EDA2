package Reto001.Ejercicio1;

public class FrameList {
    private NodoFrame primero;
    private NodoFrame segundo;
    private int tamaño;

    public FrameList() {
        this.primero = null;
        this.segundo = null;
        this.tamaño = 0;
    }

    // Agrega un frame a la lista (se permite, en este ejemplo, hasta 2 frames)
    public void addFrame(Frame frame) {
        NodoFrame nuevo = new NodoFrame(frame);
        if (primero == null) {
            primero = nuevo;
            tamaño++;
        } else if (segundo == null) {
            segundo = nuevo;
            // Establecer enlaces entre los dos nodos
            primero.setSiguiente(nuevo);
            nuevo.setAnterior(primero);
            tamaño++;
        } else {
            System.out.println("Solo se permiten 2 frames en este ejemplo.");
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

