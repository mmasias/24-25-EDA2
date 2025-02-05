import java.util.Timer;
import java.util.TimerTask;

public class Grafica {
    private final int tasaHZ = 60;
    private Cola colaFrames;

    public Grafica() {
        this.colaFrames = new Cola();
        generarFrames();
    }

    private void generarFrames() {
        Timer temporizador = new Timer();
        temporizador.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                colaFrames.enqueue(new Frame());
            }
        }, 0, 1000 / tasaHZ);
    }

    public Frame[] devolverDosFrames() {
        return colaFrames.desenqueue();
    }
}
