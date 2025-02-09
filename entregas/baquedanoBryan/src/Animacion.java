public class Animacion {
    private ListaFrame frames;
    private int timer;

    public Animacion(int timer) {
        this.frames = new ListaFrame();
        this.timer = timer > 0 ? timer : 1000;
    }

    public void agregarFrame(Frame frame) {
        frames.agregar(frame);
    }

    public void reproducir() {
        if (frames.getTamaño() < 2) {
            System.out.println("Se necesitan al menos dos Frames para animar.");
            return;
        }

        int indice = 0;

        while (true) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            Frame frameIzquierdo = frames.obtener(indice);
            Frame frameDerecho = frames.obtener((indice + 1) % frames.getTamaño());
            Pantalla.mostrarFrames(frameIzquierdo, frameDerecho);

            indice = (indice + 1) % frames.getTamaño();

            try {
                Thread.sleep(timer);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
