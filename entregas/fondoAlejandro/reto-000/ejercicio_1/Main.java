class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();
        pantalla.mostrarEntrelazado();

        Buffer buffer = new Buffer();
        buffer.entrelazarFrames();
        buffer.alternanciaRapida();

        Frames frames = new Frames();
        frames.actualizarFrame();

        Pixel pixel = new Pixel();
        pixel.pixel = 5;
        pixel.actualizarPixel();
    }
}