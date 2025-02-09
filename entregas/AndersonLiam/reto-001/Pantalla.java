import java.util.ArrayList;
import java.util.List;

public class Pantalla {
    private List<Frame> frames;

    public Pantalla() {
        this.frames = new ArrayList<>();
    }

    public void mostrarFrame(Frame frame) {
        System.out.println("Mostrando frame:");
        for (int y = 0; y < frame.getAlto(); y++) {
            for (int x = 0; x < frame.getAncho(); x++) {
                String color = frame.obtenerPixel(x, y).getColor();
                char simbolo = obtenerSimbolo(color);
                System.out.print(simbolo + " ");
            }
            System.out.println();
        }
    }

    private char obtenerSimbolo(String color) {
        switch (color.toLowerCase()) {
            case "rojo":
                return '#';
            case "verde":
                return '@';
            case "azul":
                return '*';
            case "amarillo":
                return '+';
            case "blanco":
            default:
                return '.';
        }
    }

    public void agregarFrame(Frame frame) {
        frames.add(frame);
    }
}