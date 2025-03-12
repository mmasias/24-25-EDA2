class Pila {
    private Node cima;

    private static class Node {
        String dato;
        Node siguiente;

        Node(String dato) {
            this.dato = dato;
            this.siguiente = null;
        }
    }

    public void apilar(String dato) {
        Node nuevo = new Node(dato);
        nuevo.siguiente = cima;
        cima = nuevo;
    }

    public String desapilar() {
        if (estaVacia()) return null;
        String dato = cima.dato;
        cima = cima.siguiente;
        return dato;
    }

    public String cima() {
        return estaVacia() ? null : cima.dato;
    }

    public boolean estaVacia() {
        return cima == null;
    }
}