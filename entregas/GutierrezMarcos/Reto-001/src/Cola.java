public class Cola {

    private NodoFrame primero;
    private NodoFrame ultimo;
    private int tamaño;

    public Cola(){
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public synchronized void enqueue(){
        NodoFrame nuevoNodo = new NodoFrame();
        if(tamaño == 0){
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        tamaño++;
        notifyAll();
    }

    public synchronized Frame[] desenqueue(){
        while(tamaño < 2) {
            try {
                wait();
            } catch(InterruptedException e) {
                Thread.currentThread().interrupt();
                return null;
            }
        }
        Frame[] frames = new Frame[2];
        frames[0] = primero;
        frames[1] = primero.getSiguiente();
        
        if (primero.getSiguiente() != null) {
            primero = primero.getSiguiente().getSiguiente();
        } else {
            primero = null;
        }
        tamaño -= 2;
        if(tamaño == 0) {
            ultimo = null;
        }
        return frames;
    }
}
