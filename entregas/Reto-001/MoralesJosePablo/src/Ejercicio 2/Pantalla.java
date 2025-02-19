public class Pantalla {

    @SuppressWarnings("unused")
    private String nombre;

    public Pantalla(String nombre) {
        this.nombre = nombre;
    }

    public Frame1 getFrame1(char[][] contenido, Pixel posicion) {
        return new Frame1(contenido, posicion);
    }

    public Frame2 getFrame2(char[][] contenido, Pixel posicion) {
        return new Frame2(contenido, posicion);
    }

    public void iniciarAplicacion() {
        int width = 7, height = 3;
        Pixel p1 = new Pixel(2, 2);
        Pixel p2 = new Pixel(3, 3);
        @SuppressWarnings("unused")
        Compuestos colores = new Compuestos(800, 600);

        Frame1 f1 = new Frame1(new char[][] {
            { '.', '.', '.', '#', '#', '.', '.' },
            { '+', '+', '.', '.', '.', '.', '.' },
            { '#', '#', '#', '.', '.', '.', '.' }
        }, p1);

        Frame2 f2 = new Frame2(new char[][] {
            { '.', '.', '.', '#', '#', '.', '.' },
            { '+', '+', '.', '.', '.', '.', '.' },
            { '#', '#', '#', '.', '.', '.', '.' }
        }, p2);

        ResultadoVisual rv = new ResultadoVisual(width, height);
        rv.combinar(f1, f2);
        rv.mostrarResultado();
    }

    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla("ClaseEjemplo");
        pantalla.iniciarAplicacion();
    }
}