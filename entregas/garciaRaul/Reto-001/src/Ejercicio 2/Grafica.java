public class Grafica {

    private final int memoriaKB = 16;
    private final int tasaHZ = 60;
    private Cola colaFrames;

    public Grafica(){
        this.colaFrames = new Cola();
    }

    public void generarFrames(){
        colaFrames.enqueue(); 
    }

    public Frame[] devolverDosFrames(){
        return colaFrames.dequeue();
    }

}