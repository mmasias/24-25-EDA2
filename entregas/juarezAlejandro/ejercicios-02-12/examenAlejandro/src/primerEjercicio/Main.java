package primerEjercicio;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla("Pantalla");

        Frame frame1 = Frame.crearFrame1();
        Frame frame2 = Frame.crearFrame2();
        ResultadoCombinado resultado = new ResultadoCombinado(3, 7);

        pantalla.getFrame(frame1, frame2, resultado);
    }
}