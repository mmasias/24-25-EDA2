package Examen;
public class Main {
    public static void main(String[] args) {
        int width = 7, height = 3;
        Frame frame1 = new Frame(width, height);
        Frame frame2 = new Frame(width, height);

        // Definir píxeles en los frames
        frame1.setPixel(1, 1, '#');
        frame1.setPixel(3, 1, '+');
        frame1.setPixel(5, 1, '-');

        frame2.setPixel(1, 1, '.');
        frame2.setPixel(3, 1, '#');
        frame2.setPixel(5, 1, '+');

        Display display = new Display(frame1, frame2);

        // Mostrar los frames individualmente
        display.updateDisplay();
        display.switchFrame();
        display.updateDisplay();

        // Mostrar el resultado combinado
        display.renderCombinedFrames();
    }
}
