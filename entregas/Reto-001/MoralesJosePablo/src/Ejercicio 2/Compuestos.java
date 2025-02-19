public class Compuestos {

    private char[][] colores;

    public Compuestos(int ancho, int alto) {
        colores = new char[alto][ancho];
    }

    public char[][] listaColores() {
        return colores;
    }
}