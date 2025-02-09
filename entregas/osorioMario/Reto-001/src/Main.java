public class Main {
    public static void main(String[] args) {
        GraphicsSystem system = new GraphicsSystem(5, 5, 1000);
        
        system.updatePixel(2, 2, "X");
        system.render();

        system.startPatternSwitch(2000); // Alterna patrones cada 2 segundos
    }
}
