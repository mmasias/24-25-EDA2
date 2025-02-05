package entregas.martinezDiego.reto0;

class Lista {
    private Nodo cabeza;
    
    public void anadirNodo(int ancho, int alto) {
        Nodo nuevo = new Nodo(ancho, alto);
        if (cabeza == null) {
            cabeza = nuevo;
            cabeza.siguiente = cabeza;
            cabeza.anterior = cabeza;
        } else {
            Nodo ultimo = cabeza.anterior;
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            nuevo.siguiente = cabeza;
            cabeza.anterior = nuevo;
        }
    }
    
    public Nodo obtenerNodo() {
        return cabeza;
    }
}
