
public class Main {
    public static void main(String[] args) {
        GestorPantalla gestor = new GestorPantalla(7, 7, 3);

        gestor.establecerPixel(new Coordenada(1, 1), 1);
        gestor.establecerPixel(new Coordenada(2, 2), 2);
        gestor.establecerPixel(new Coordenada(3, 3), 3);

        System.out.println("Frame Actual:");
        gestor.renderizar();

        gestor.establecerPixel(new Coordenada(1, 2), 4);
        gestor.establecerPixel(new Coordenada(2, 3), 5);
        
        System.out.println("Siguiente Frame:");
        gestor.renderizar();
    }
}

