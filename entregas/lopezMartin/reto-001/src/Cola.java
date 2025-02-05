public class Cola {

    private NodoFrame primero;
    private NodoFrame ultimo;
    private int tamaño;

    public Cola(){
        this.primero = null;
        this.ultimo = null;
        this.tamaño = 0;
    }

    public void enqueue(){

        NodoFrame nuevoNodo = new NodoFrame();

        if(this.tamaño==0){
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        }else{
            NodoFrame actual = primero;
            while(actual.getSiguiente()!=null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        this.tamaño++;
    }

    public Frame[] desenqueue(){
        if (tieneDosFrames()) {
            Frame[] frames = new Frame[2];
            NodoFrame actual = primero;
            while (actual.getSiguiente() != null && actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            frames[0] = actual.getSiguiente();
            frames[1] = actual.getSiguiente().getSiguiente();
            actual.setSiguiente(null);
            this.tamaño -=2;
            return frames;
        }else{
            return null;
        }

    }

    public Frame[] peek(){
        if (tieneDosFrames()) {
            Frame[] frames = new Frame[2];
            NodoFrame actual = primero;
            while (actual.getSiguiente() != null && actual.getSiguiente().getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            frames[0] = actual.getSiguiente();
            frames[1] = actual.getSiguiente().getSiguiente();
            return frames;
        }else{
            return null;
        }
    }

    private boolean tieneDosFrames(){
        return tamaño>=2;
    }
    
}