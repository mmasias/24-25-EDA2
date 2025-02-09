public class Main {
    public static void main(String[] args) {
        Frame frame1 = new Frame(5, 5);
        Frame frame2 = new Frame(5, 5);

        frame1.establecerPixel(0, 0, "rojo");
        frame1.establecerPixel(1, 1, "verde");
        frame1.establecerPixel(2, 2, "azul");
        frame1.establecerPixel(3, 3, "amarillo");
        frame1.establecerPixel(4, 4, "rojo");

        frame2.establecerPixel(0, 4, "azul");
        frame2.establecerPixel(1, 3, "amarillo");
        frame2.establecerPixel(2, 2, "verde");
        frame2.establecerPixel(3, 1, "rojo");
        frame2.establecerPixel(4, 0, "azul");

        ControlDeEnlazado controlador = new ControlDeEnlazado();
        controlador.establecerFrames(frame1, frame2);

        Frame frameCombinado = controlador.getFrameRestante();

        Pantalla pantalla = new Pantalla();
        pantalla.agregarFrame(frame1);
        pantalla.agregarFrame(frame2);
        pantalla.mostrarFrame(frameCombinado);
    }
}