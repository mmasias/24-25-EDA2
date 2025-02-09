public class Main {
    public static void main(String[] args) {
        InterlacedDisplay display = new InterlacedDisplay(14, 3);

        display.setPixel(1, 0, '#');
        display.setPixel(9, 2, '+');
        display.render();
    }

}
