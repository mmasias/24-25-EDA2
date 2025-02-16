public class Coordenada {
    private int x;
    private int y;

    public Coordenada(int columna, int fila) {
        this.x = columna;
        this.y = fila;
    }

    public int obtenerX() {
        return x;
    }

    public int obtenerY() {
        return y;
    }
}