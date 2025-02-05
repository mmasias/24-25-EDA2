public class Cola {
    private NodoFrame primero;
    private NodoFrame ultimo;
    private int tamaño;

    public Cola() {
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public void enqueue(Frame frame) {
        NodoFrame nuevoNodo = new NodoFrame(frame);
        if (this.tamaño == 0) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        this.tamaño++;
    }

    public Frame[] desenqueue() {
        if (!tieneDosFrames()) return null;
        
        Frame[] frames = new Frame[2];
        frames[0] = primero.getFrame();
        frames[1] = primero.getSiguiente().getFrame();
        
        primero = primero.getSiguiente().getSiguiente();
        if (primero == null) {
            ultimo = null;
        }
        this.tamaño -= 2;
        return frames;
    }

    public Frame[] peek() {
        if (!tieneDosFrames()) return null;
        return new Frame[]{primero.getFrame(), primero.getSiguiente().getFrame()};
    }

    private boolean tieneDosFrames() {
        return tamaño >= 2;
    }
}