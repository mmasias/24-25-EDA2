package entregas.Reyes_David.Reto001.Ejercicio_1;

public class DobleBuffer {
    private Frame frame1;
    private Frame frame2;
    private boolean alternar;

    public DobleBuffer(Frame1 frame1, Frame2 frame2) {
        this.frame1 = frame1;
        this.frame2 = frame2;
        this.alternar = true;
    }

    public void mostrarFrame() {
        if (alternar) {
            System.out.println("Frame 1:");
            frame1.mostrarPixeles();
        } else {
            System.out.println("Frame 2:");
            frame2.mostrarPixeles();
        }
        alternar = !alternar;
    }
}
