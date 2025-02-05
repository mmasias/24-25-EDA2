package entregas.celayaIker.Ejercicio2;

public class Main {
    public static void main(String[] args) {
        Pantalla pantalla = new Pantalla();

        pantalla.modificarPixel(0, 10, 10, 255);

        pantalla.alternarColores();
        pantalla.alternarColores(); 
    }
}
