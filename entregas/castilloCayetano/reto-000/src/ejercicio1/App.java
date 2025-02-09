package ejercicio1;

public class App {
    public class Main {
        public static void main(String[] args) {
            Pantalla pantalla = new Pantalla();

            pantalla.modificarPixel(0, 10, 255);
    
            pantalla.alternarFrames();
            pantalla.alternarFrames();
        }
    }
}