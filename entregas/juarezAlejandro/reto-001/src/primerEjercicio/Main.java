package primerEjercicio;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla("Pantalla");

        Frame1 frame1 = new Frame1(3, 7);
        Frame2 frame2 = new Frame2(3, 7);
        ResultadoCombinado resultado = new ResultadoCombinado(3, 7);

        pantalla.getFrame(frame1, frame2, resultado);
    }
}
