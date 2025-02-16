package ejercicios.Ejercicio_12_02.Ejercicio_2;

public class Demo {
    public static void main(String[] args) {
        Dimension d = new Dimension(6, 5);
        GestorPantalla pantalla = new GestorPantalla(d);
        pantalla.establecerPixel(new Coordenada(3, 2), 2);
        pantalla.renderizar();
    }
}