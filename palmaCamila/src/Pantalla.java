public class Pantalla {
    private Nodo dato;
    private Nodo cabeza;

    public Pantalla() {
        this.dato = null;
        this.cabeza = null;
    }

    public void printFrame(int frameIndex1, int frameIndex2) {
        if (cabeza != null) {
            Nodo temp = cabeza;
            for (int i = 0; i < frameIndex1; i++) {
                temp = temp.getSiguiente();
            }
            Frame frame1 = temp.getDato();
            temp = cabeza;
            for (int i = 0; i < frameIndex2; i++) {
                temp = temp.getSiguiente();
            }
            Frame frame2 = temp.getDato();
            Pixel[][] pixels1 = frame1.getPixel();
            Pixel[][] pixels2 = frame2.getPixel();
            for (int i = 0; i < pixels1.length; i++) {
                for (int j = 0; j < pixels1[i].length; j++) {
                    System.out.print(pixels1[i][j].getAsterisco() + " ");
                }
                for (int j = 0; j < pixels2[i].length; j++) {
                    System.out.print(pixels2[i][j].getAsterisco() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay frames para mostrar.");
        }
    }

    public Frame asigneNextFrame() {
        if (cabeza == null) {
            return null;
        }
        if (cabeza.getSiguiente() != null) {
            cabeza = cabeza.getSiguiente();
        }
        return cabeza.getDato();
    }

    public void verifyBuffer() {
        if (cabeza == null) {
            System.out.println("El buffer de la pantalla está vacío.");
        } else {
            System.out.println("El buffer de la pantalla tiene frames.");
        }
    }

    public void printIndividualFrame(int index) {
        if (cabeza != null) {
            Nodo temp = cabeza;
            for (int i = 0; i < index; i++) {
                temp = temp.getSiguiente();
            }
            Frame frame = temp.getDato();
            Pixel[][] pixels = frame.getPixel();
            for (int i = 0; i < pixels.length; i++) {
                for (int j = 0; j < pixels[i].length; j++) {
                    System.out.print(pixels[i][j].getAsterisco() + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No hay frames para mostrar.");
        }
    }

    public Frame getFrames() {
        return (cabeza != null) ? cabeza.getDato() : null;
    }

    public void agregarFrame(Frame frame) {
        Nodo nuevoNodo = new Nodo(frame);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            dato = nuevoNodo;
        } else {
            Nodo temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(temp);
        }
    }
}
