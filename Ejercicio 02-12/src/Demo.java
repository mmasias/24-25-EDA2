import java.util.Random;

public class Demo {
    public static void main(String[] args) {
        Resolucion resolucion = new Resolucion(8, 3);
        GestorPantalla pantalla = new GestorPantalla(resolucion);

        Random rand = new Random();
        for (int i = 0; i < 5; i++) {
            int x = rand.nextInt(resolucion.obtenerAncho());
            int y = rand.nextInt(resolucion.obtenerAlto());
            pantalla.establecerPixel(new Coordenada(x, y), 2);
        }

        pantalla.renderizar();
    }
}