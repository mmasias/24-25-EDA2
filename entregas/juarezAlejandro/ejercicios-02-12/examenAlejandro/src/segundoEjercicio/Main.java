package segundoEjercicio;

public class Main {
    public static void main(String[] args) {

        Pantalla pantalla = new Pantalla("Pantalla");

        Frame frame1 = Frame.crearFrame1();
        Frame frame2 = Frame.crearFrame2();

        ResultadoVisual resultado = new ResultadoVisual(3, 4);

        pantalla.agregarFrame(frame1);
        pantalla.agregarFrame(frame2);

        pantalla.mostrarFrames();

        resultado.combinar(frame1, frame2);
    }
}