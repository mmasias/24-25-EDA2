public class Demo {
    public static void main(String[] args) {
        Resolucion resolucion = new Resolucion(10, 5);
        GestorPantalla gestor = new GestorPantalla(resolucion);
        gestor.establecerPixel(new Coordenada(2, 1), 1);
        gestor.establecerPixel(new Coordenada(7, 3), 2);
        gestor.renderizar();
    }
}
