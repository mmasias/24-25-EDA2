public class Main {
    public static void main(String[] args) {
    
        Pantalla pantalla = new Pantalla();
        pantalla.agregarFrame(new Frame(3, 8));;
        pantalla.agregarFrame(new Frame(3, 8));

        pantalla.getFrame().actualizarPixel(0, 1, '#');
        pantalla.getFrame().actualizarPixel(1, 2, '#');
        pantalla.getFrame().actualizarPixel(2, 3, '#');
        
        pantalla.asignarSiguienteFrame();
        pantalla.getFrame().actualizarPixel(0, 5, '+');
        pantalla.getFrame().actualizarPixel(1, 6, '+');
        pantalla.getFrame().actualizarPixel(2, 7, '+');

        pantalla.imprimirPantalla();
    }
}
