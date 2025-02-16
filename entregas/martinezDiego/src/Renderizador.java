class Renderizador {
    public static void renderizar(Frame frame1, Frame frame2) {
        for (int y = 0; y < 10; y++) { // Limitar la salida para evitar impresión infinita
            for (int x = 0; x < 10; x++) { // Reducir el tamaño para visualización
                System.out.print(frame1.getPixel(x, y).getValor());
            }
            System.out.print(" | ");
            for (int x = 0; x < 10; x++) {
                System.out.print(frame2.getPixel(x, y).getValor());
            }
            System.out.println();
        }
    }
}
