public class Main {
    public static void main(String[] args) {
        Frame frame1 = new Frame(7, 7);
        Frame frame2 = new Frame(7, 7);

        frame1.setPixel(1, 0, '#');
        frame1.setPixel(2, 1, '+');
        frame1.setPixel(3, 2, '@');

        frame2.setPixel(1, 1, '*');
        frame2.setPixel(2, 2, '%');
        frame2.setPixel(3, 3, '&');

        System.out.println("Frame 1:");
        frame1.renderizar();

        System.out.println("Frame 2:");
        frame2.renderizar();

        Interfaz interfaz = new Interfaz(frame1, frame2);
        Frame combinado = interfaz.combinarFrames();

        System.out.println("Frame Combinado:");
        combinado.renderizar();
    }
}
