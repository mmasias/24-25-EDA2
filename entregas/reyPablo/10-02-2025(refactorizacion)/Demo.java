public class Demo {
    public static void main(String[] args) {
        GestorPantalla gestor = new GestorPantalla(5);
        gestor.establecerPixel(new Coordenada(2, 1), 1);
        gestor.establecerPixel(new Coordenada(7, 3), 2);
        gestor.renderizar();
    }
}
