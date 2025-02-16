package segundoEjercicio;

import java.util.ArrayList;

public class Pantalla {
    private String clase;
    private ArrayList<Frame> frames;

    public Pantalla(String clase) {
        this.clase = clase;
        this.frames = new ArrayList<>();
    }

    public void agregarFrame(Frame frame) {
        frames.add(frame);
    }

    public void mostrarFrames() {
        for (int i = 0; i < frames.size(); i++) {
            System.out.println("Mostrando Frame " + (i + 1) + ":");
            frames.get(i).posicionFrame();
            System.out.println("-".repeat(20));
        }
    }
}