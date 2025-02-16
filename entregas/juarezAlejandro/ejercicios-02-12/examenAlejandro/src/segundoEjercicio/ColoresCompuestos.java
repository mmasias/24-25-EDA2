package segundoEjercicio;

public class ColoresCompuestos {
    private char[][] colores;

    public ColoresCompuestos(int ancho, int alto) {
        colores = new char[ancho][alto];
    }

    public char[][] listaColores() {
        return colores;
    }
}