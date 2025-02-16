public class ListaFrame {
    private NodoFrame cabeza;
    private NodoFrame cola;
    private int tamaño;

    public ListaFrame() {
        this.cabeza = null;
        this.cola = null;
        this.tamaño = 0;
    }

    public void agregar(Frame frame) {
        NodoFrame nuevo = new NodoFrame(frame);

        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
        } else {
            cola.siguiente = nuevo;
            cola = nuevo;
        }

        tamaño++;
    }

    public Frame obtener(int indice) {
        if (indice < 0 || indice >= tamaño) {
            return null;
        }

        NodoFrame actual = cabeza;
        for (int i = 0; i < indice; i++) {
            actual = actual.siguiente;
        }

        return actual.dato;
    }

    public int getTamaño() {
        return tamaño;
    }
}
