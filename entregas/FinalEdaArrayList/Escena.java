import java.util.ArrayList;

public class Escena {
    private ArrayList<Frame>frames;
    private int indiceActual;
    public Escena(Resolucion resolucion,int nFrames){
        this.frames=new ArrayList<>();

        for (int i = 0; i < nFrames; i++) {
            this.frames.add(new Frame(resolucion));
        }
        this.indiceActual=0;
    }

    public void siguiente(){

        this.indiceActual=(this.indiceActual+1)%frames.size();

    }

    public Frame getFrame(){

        return this.frames.get(indiceActual);
    } 
    public Frame getFrame(int indice){
        if (indice>0 && indice<frames.size()) {

            return this.frames.get(indice);
        }
        return null;
    }
    public int nFrames(){
        return frames.size();
    }
    }
