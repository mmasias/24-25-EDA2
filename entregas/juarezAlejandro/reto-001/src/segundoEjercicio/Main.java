package segundoEjercicio;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla("Pantalla");

        Frame1 frame1 = new Frame1(3, 4);
        Frame2 frame2 = new Frame2(3, 4);
        ResultadoVisual resultado = new ResultadoVisual(3, 4);

        pantalla.getFrame(frame1, frame2, resultado);
    }
}
