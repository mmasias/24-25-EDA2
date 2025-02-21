package Reto001.Ejercicio1;

public class Pantalla {
    private FrameList frameList;
    private NodoFrame currentFrame;

    public Pantalla(FrameList frameList) {
        this.frameList = frameList;
        this.currentFrame = frameList.getPrimero();
    }

    public void AlternarFrame() {
        if (frameList.getPrimero() == null || frameList.getSegundo() == null) {
            System.out.println("No se puede alternar frame, falta alguno.");
            return;
        }
        if (currentFrame == frameList.getPrimero()) {
            currentFrame = frameList.getSegundo();
        } else {
            currentFrame = frameList.getPrimero();
        }
        System.out.println("Frame alternado.");
    }

    public void MostrarFrameListActual() {
        if (currentFrame != null) {
            System.out.println("Frame actual:");
            currentFrame.getFrame().pintar();
        } else {
            System.out.println("No hay frame actual.");
        }
    }

    public void MostrarFrameListSiguiente() {
        if (frameList.getPrimero() == null || frameList.getSegundo() == null) {
            System.out.println("No hay siguiente frame.");
            return;
        }
        NodoFrame nextFrame = (currentFrame == frameList.getPrimero() ? frameList.getSegundo() : frameList.getPrimero());
        System.out.println("Frame siguiente:");
        nextFrame.getFrame().pintar();
    }
}
