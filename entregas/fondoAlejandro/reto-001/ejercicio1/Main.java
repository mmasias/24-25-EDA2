import java.util.Random;

class Main {
    public static void main(String[] args) {
        Random random = new Random();
        GestorPantalla gestor = new GestorPantalla(7, 3);

        gestor.establecerPixelFrame1(new Coordenada(0, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(1, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(2, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(3, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(4, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(5, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(6, 0), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(0, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(1, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(2, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(3, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(4, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(5, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(6, 1), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(0, 2), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(1, 2), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(2, 2), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(3, 2), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(4, 2), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(5, 2), random.nextInt(10));
        gestor.establecerPixelFrame1(new Coordenada(6, 2), random.nextInt(10));
        gestor.cambiarFrame();

        gestor.establecerPixelFrame2(new Coordenada(0, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(1, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(2, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(3, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(4, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(5, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(6, 0), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(0, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(1, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(2, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(3, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(4, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(5, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(6, 1), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(0, 2), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(1, 2), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(2, 2), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(3, 2), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(4, 2), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(5, 2), random.nextInt(10));
        gestor.establecerPixelFrame2(new Coordenada(6, 2), random.nextInt(10));
        gestor.cambiarFrame();

        System.out.println("Frame 1:");
        gestor.renderizarFrame(0);
        System.out.println();

        System.out.println("Frame 2:");
        gestor.renderizarFrame(1);
        System.out.println();

        System.out.println("Salida entrelazada:");
        Pixel[][] salida = gestor.obtenerSalidaEntrelazada();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 14; x++) {
                System.out.print(salida[y][x].obtenerColor() + " ");
            }
            System.out.println();
        }
    }
}