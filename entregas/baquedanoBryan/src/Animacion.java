import java.util.ArrayList;

public class Animacion {
    private ArrayList<Frame> frames;
    private int timer;
    private int indiceActual;

    public Animacion(int timer) {
        this.frames = new ArrayList<>();
        this.timer = timer > 0 ? timer : 1000;
        this.indiceActual = 0;
    }

    public void agregarFrame(Frame frame) {
        frames.add(frame);
    }

    public void reproducir() {
        if (frames.size() < 2) {
            System.out.println("Se necesitan al menos dos Frames para animar.");
            return;
        }

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            Frame frameIzquierdo = frames.get(indiceActual);
            Frame frameDerecho = frames.get((indiceActual + 1) % frames.size());

            Pantalla.mostrarFrames(frameIzquierdo, frameDerecho);

            indiceActual = (indiceActual + 1) % frames.size(); 

            try {
                Thread.sleep(timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
