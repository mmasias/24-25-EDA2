class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();
        pantalla.duplicarFrames();
        pantalla.mostrarDuplicado();
        
        ColoresBase colores = new ColoresBase();
        colores.mostrarColores();
        
        PatronesColor patrones = new PatronesColor();
        patrones.mostrarPatrones();
        
        Alternancia alternancia = new Alternancia();
        alternancia.combinarColoresBase();
        alternancia.alternarColores();
        alternancia.temporizado();

        Frames frames = new Frames();
        frames.actualizarFrame();

        Pixel pixel = new Pixel();
        pixel.pixel = 5;
        pixel.actualizarPixel();
    }
}