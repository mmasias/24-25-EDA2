public class Main {
    public static void main(String[] args) {
        GraphicsSystem system = new GraphicsSystem(5, 5, 2000);

        // Simulación de actualización de píxeles individuales
        system.updatePixel(2, 2, "Blanco");
        system.render();
    }
}
