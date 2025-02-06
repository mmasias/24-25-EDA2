package entregas.Reyes_David.Reto001.Ejercicio_1;

public class Frame {
    protected PixelGraph pixelGraph;

    public Frame(int filas, int columnas) {
        this.pixelGraph = new PixelGraph(filas, columnas);
    }

    public void addPixel(int fila, int columna, char simbolo) {
        pixelGraph.addPixel(fila, columna, simbolo);
    }

    public void mostrarPixeles() {
        pixelGraph.mostrarPixeles();
    }
}
