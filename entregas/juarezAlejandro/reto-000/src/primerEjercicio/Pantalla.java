package primerEjercicio;

public class Pantalla {
    private String clase;

    public Pantalla(String clase) {
        this.clase = clase;
    }

    private void getFrame() {
        Buffer buffer = new Buffer();
        Frame1 frame1 = new Frame1();
        Frame2 frame2 = new Frame2();
        ResultadoCombinado resultado = new ResultadoCombinado();

        buffer.mostrarFrameEscogido(frame1, frame2, resultado);
    }

    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla("Pantalla");
        pantalla.getFrame();
    }
}