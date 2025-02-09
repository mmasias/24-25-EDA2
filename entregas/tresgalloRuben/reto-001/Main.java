public class Main {
    public static void main(String[] args) {
        Frame frame1 = new Frame(7, 3);
        Frame frame2 = new Frame(7, 3);

        frame1.setPixel(1, 0, '#');
        frame1.setPixel(2, 0, '#');
        frame1.setPixel(3, 0, '#');

        frame2.setPixel(4, 0, '#');
        frame2.setPixel(5, 0, '#');
        frame2.setPixel(6, 0, '#');

        Interfaz interfaz = new Interfaz(frame1, frame2);

        System.out.println("Frame Actual:");
        interfaz.actualizarPantalla();

        interfaz.cambiarFrame();
        System.out.println("\nCambiando frame...");
        interfaz.actualizarPantalla();

        System.out.println("\nFrames combinados:");
        char[][] combinado = interfaz.combinarFrames();
        for (char[] fila : combinado) {
            for (char c : fila) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
