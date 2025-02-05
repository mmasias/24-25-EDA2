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
        if(this.tamaño==0){
            NodoFrame nuevoNodo = new NodoFrame();
            primero = nuevoNodo;
        }else{
            NodoFrame actual = primero;
            while(actual.getSiguiente()!=null){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente();
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
            NodoFrame siguiente = actual.getSiguiente();
            siguiente = null;
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