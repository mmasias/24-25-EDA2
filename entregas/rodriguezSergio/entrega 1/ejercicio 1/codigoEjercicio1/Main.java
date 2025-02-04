public class Main {
    public static void main(String[] args) {
        BufferPantalla buffer = new BufferPantalla(4, 4);

        buffer.actualizarPixel(buffer.getFrame1(), 0, 0, 100);
        buffer.actualizarPixel(buffer.getFrame2(), 0, 0, 200);
        buffer.actualizarPixel(buffer.getFrame1(), 1, 1, 150);
        buffer.actualizarPixel(buffer.getFrame2(), 1, 1, 50);

        Rendimiento rendimiento = new Rendimiento(buffer);

        rendimiento.renderizar();

        rendimiento.alternarFrame();
        rendimiento.renderizar();
    }
}
