package ejercicio2;

public class App {
    
    public class Main {
        public static void main(String[] args) {
            Pantalla pantalla = new Pantalla();
    
            pantalla.modificarPixel(0, 10, 10, 255);
    
            pantalla.alternarColores();
            pantalla.alternarColores(); 
        }
    }
}
