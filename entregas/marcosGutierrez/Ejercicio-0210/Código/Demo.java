public class Demo {
    public static void main(String[] args) {
        GestorPantalla pantalla = new GestorPantalla(8,3);

        pantalla.establecerPixel(new Coordenada(7,2),2);
        pantalla.establecerPixel(new Coordenada(6,1),2);
        pantalla.establecerPixel(new Coordenada(5,0),2);
        pantalla.renderizar();
    }
}
