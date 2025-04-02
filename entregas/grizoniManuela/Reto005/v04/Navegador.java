package Reto005.v04;


public class Navegador {
    private HojaDeCalculo hoja;
    private int filaActual;
    private int columnaActual;

    public Navegador(HojaDeCalculo hoja) {
        this.hoja = hoja;
        this.filaActual = 0;
        this.columnaActual = 0;
    }

    public Celda getCeldaActual() {
        return hoja.getCelda(filaActual, columnaActual);
    }

    public void moverArriba() {
        if (filaActual > 0) {
            filaActual--;
        }
    }

    public void moverAbajo() {
        if (filaActual < hoja.getNumeroDeFilas() - 1) {
            filaActual++;
        }
    }

    public void moverIzquierda() {
        if (columnaActual > 0) {
            columnaActual--;
        }
    }

    public void moverDerecha() {
        if (columnaActual < hoja.getNumeroDeColumnas() - 1) {
            columnaActual++;
        }
    }
}