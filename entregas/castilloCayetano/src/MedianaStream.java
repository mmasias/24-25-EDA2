public class MedianaStream {
    // Completado
    private Nodo cabeza;
    private int tamaño;

    public MedianaStream() {
        cabeza = null;
        tamaño = 0;
    }

    public static void main(String[] args) {
        imprimirMedianaStream();
    }

    public void mostrar() {
        imprimirMedianaStream();
    }

    public static void imprimirMedianaStream() {
        MedianaStream medianaStream = new MedianaStream();
        int[] stream = { 1, 3, 2, 4, 5 };
        for (int num : stream) {
            medianaStream.agregarNumero(num);
            System.out.println(medianaStream.encontrarMediana());
        }
    }

    public void agregarNumero(int num) {
        cabeza = insertarNodo(cabeza, num);
        tamaño++;
    }

    public double encontrarMediana() {
        if (tamaño == 0) {
            throw new IllegalStateException("No hay elementos en el stream");
        }
        Nodo actual = cabeza;
        for (int i = 0; i < (tamaño - 1) / 2; i++) {
            actual = actual.siguiente;
        }
        if (tamaño % 2 == 0) {
            return (actual.valor + actual.siguiente.valor) / 2.0;
        } else {
            return actual.valor;
        }
    }

    private Nodo insertarNodo(Nodo cabeza, int valor) {
        Nodo nuevoNodo = new Nodo(valor);
        if (cabeza == null || valor < cabeza.valor) {
            nuevoNodo.siguiente = cabeza;
            return nuevoNodo;
        }
        Nodo actual = cabeza;
        while (actual.siguiente != null && actual.siguiente.valor < valor) {
            actual = actual.siguiente;
        }
        nuevoNodo.siguiente = actual.siguiente;
        actual.siguiente = nuevoNodo;
        return cabeza;
    }

    private class Nodo {
        int valor;
        Nodo siguiente;

        Nodo(int valor) {
            this.valor = valor;
            this.siguiente = null;
        }
    }
}