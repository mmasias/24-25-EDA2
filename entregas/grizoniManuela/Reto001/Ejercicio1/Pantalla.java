package Reto001.Ejercicio1;

public class Pantalla {
    private FrameList frameList;
    // Se utiliza currentFrame para indicar el frame actual en la pantalla
    private NodoFrame currentFrame;

    public Pantalla(FrameList frameList) {
        this.frameList = frameList;
        // Si existe al menos un frame, se asigna el primero como actual
        this.currentFrame = frameList.getPrimero();
    }

    // Alterna entre el primer y segundo frame
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

    // Muestra el frame actual, invocando su método pintar()
    public void MostrarFrameListActual() {
        if (currentFrame != null) {
            System.out.println("Frame actual:");
            currentFrame.getFrame().pintar();
        } else {
            System.out.println("No hay frame actual.");
        }
    }

    // Muestra el frame que no está activo (el siguiente)
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
