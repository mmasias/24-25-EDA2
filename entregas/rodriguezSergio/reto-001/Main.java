public class Main {
    public static void main(String[] args) {
        BufferPantalla buffer = new BufferPantalla(4, 4);

        buffer.actualizarPixel(buffer.getFrame1(), 0, 0, "Negro");
        buffer.actualizarPixel(buffer.getFrame2(), 0, 0, "Blanco");

        buffer.actualizarPixel(buffer.getFrame1(), 1, 1, "Rojo");
        buffer.actualizarPixel(buffer.getFrame2(), 1, 1, "Azul");

        buffer.actualizarPixel(buffer.getFrame1(), 2, 2, "Rojo");
        buffer.actualizarPixel(buffer.getFrame2(), 2, 2, "Amarillo");

        buffer.actualizarPixel(buffer.getFrame1(), 3, 3, "Azul");
        buffer.actualizarPixel(buffer.getFrame2(), 3, 3, "Amarillo");

        Renderizador renderizador = new Renderizador(buffer);
        renderizador.renderizar();
    }
}