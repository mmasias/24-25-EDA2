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
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
        this.tamaño++;
    }

    public Frame[] dequeue(){
        Frame[] frames = new Frame[2];
        if (tieneDosFrames()) {
            frames[0] = primero;
            primero = primero.getSiguiente();
            frames[1] = primero;
            primero = primero.getSiguiente();
            this.tamaño -= 2;
        }   
        return frames;
    }

    public Frame[] peek(){
        Frame[] frames = new Frame[2];
        if (tieneDosFrames()) {
            frames[0] = primero;
            frames[1] = primero.getSiguiente();
            this.tamaño -= 2;
        }   
        return frames;
    }

    private boolean tieneDosFrames(){
        return tamaño>=2;
    }

}