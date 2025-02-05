public class ListaCircularFrames {
    private Frame[]frames;
    private int indiceActual;
    private int tamaño;

    public ListaCircularFrames(int ancho, int alto, int tamaño){
        this.tamaño = (ancho*alto);
        indiceActual = 0;
        this.frames = new Frame[2];
        this.frames[0]=new Frame(ancho,alto);
        this.frames[1]=new Frame(ancho,alto);
    }

    public void siguiente(){
        if(indiceActual == 0 ){
            indiceActual = 1;
        }else{
            indiceActual = 0;
        }
    }

    public Frame obtenerActual(){
        return frames[indiceActual];
    }
    public Frame obtenerFrame(int nuevoFrame){
        return frames[nuevoFrame];
    }
    public int tamaño(){
        return tamaño;
    }
}
