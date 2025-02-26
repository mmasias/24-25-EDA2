package Reto001.Ejercicio2;

public class Pantalla {
    private FrameList frameList;
    private NodoFrame currentFrame;

    public Pantalla(FrameList frameList) {
        this.frameList = frameList;
        this.currentFrame = frameList.getPrimero();
    }

    public void AlternarFrame() {
        if (frameList.getPrimero() != null && frameList.getSegundo() != null) {
            if (currentFrame == frameList.getPrimero()) {
                currentFrame = frameList.getSegundo();
            } else {
                currentFrame = frameList.getPrimero();
            }
            System.out.println("Frame alternado.");
        } else {
            System.out.println("No hay suficientes frames para alternar.");
        }
    }

    public void AlterarColor() {
        if (currentFrame != null) {
            currentFrame.getFrame().TiempoDeAlternancia();
        }
    }

    public void MostrarColorBlanco() {
        if (currentFrame != null) {
            currentFrame.getFrame().PintarBlanco();
        }
    }

    public void MostrarColorNegro() {
        if (currentFrame != null) {
            currentFrame.getFrame().PintarNegro();
        }
    }

    public void MostrarColorCyan() {
        if (currentFrame != null) {
            currentFrame.getFrame().PintarCyan();
        }
    }

    public void MostrarColorMagenta() {
        if (currentFrame != null) {
            currentFrame.getFrame().PintarMagenta();
        }
    }

    public void MostrarFrameListSiguiente() {
        if (frameList.getPrimero() != null && frameList.getSegundo() != null) {
            NodoFrame nextFrame = (currentFrame == frameList.getPrimero() ? frameList.getSegundo() : frameList.getPrimero());
            System.out.println("Mostrando frame siguiente:");
            nextFrame.getFrame().displayFrameInfo();
        } else {
            System.out.println("No hay frame siguiente disponible.");
        }
    }
}
