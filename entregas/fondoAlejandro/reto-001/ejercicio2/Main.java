package ejercicio2;

import java.util.Random;

class Main {
    public static void main(String[] args) {
        Random random = new Random();
        GestorPantalla gestor = new GestorPantalla(7, 3);

        char[] coloresBase = {'.', '#', '+', '*'};

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 7; x++) {
                gestor.establecerPixelFrame1(new Coordenada(x, y), coloresBase[random.nextInt(coloresBase.length)]);
            }
        }
        gestor.cambiarFrame();

        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 7; x++) {
                gestor.establecerPixelFrame2(new Coordenada(x, y), coloresBase[random.nextInt(coloresBase.length)]);
            }
        }
        gestor.cambiarFrame();

        System.out.println("Frame 1:");
        gestor.renderizarFrame(0);
        System.out.println();

        System.out.println("Frame 2:");
        gestor.renderizarFrame(1);
        System.out.println();

        System.out.println("Salida superpuesta:");
        char[][] salida = gestor.obtenerSalidaEntrelazada();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 7; x++) {
                System.out.print(salida[y][x] + " ");
            }
            System.out.println();
        }
    }
}