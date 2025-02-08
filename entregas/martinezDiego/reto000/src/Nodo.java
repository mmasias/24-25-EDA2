package entregas.martinezDiego.reto0.src;

class Nodo {
    Nodo siguiente, anterior;
    int[][] frame;
    
    public Nodo(int ancho, int alto) {
        frame = new int[alto][ancho];
    }
}
