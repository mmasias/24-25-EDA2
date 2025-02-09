package Ej01;
import java.util.Timer;
import java.util.TimerTask;

public class Grafica {

    private final int memoriaKB = 16;
    private final int hertz = 60;
    private Cola colaFrames;

    public Grafica(){
        this.colaFrames = new Cola();
        generarFrames();
    }

    private void generarFrames(){

        Timer temporizador = new Timer();

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                colaFrames.enqueue();
            }
        };
        temporizador.scheduleAtFixedRate(tarea, 0, 1000);

    }

    public Frame[] devolverDosFrames(){
        return colaFrames.desenqueue();
    }

}
