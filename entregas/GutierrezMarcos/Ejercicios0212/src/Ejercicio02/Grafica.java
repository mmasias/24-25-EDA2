package Ejercicio02;

import java.util.Queue;
import java.util.ArrayDeque;

public class Grafica {
    private Queue<Frame> colaFrames;
    
    public Grafica() {
        this.colaFrames = new ArrayDeque<>();
    }
    
    public void generarFrames() {
        colaFrames.add(new Frame());
    }
    
    public Frame[] devolverDosFrames() {
        Frame[] framesDevueltos = new Frame[2];
        if (colaFrames.size() >= 2) {
            framesDevueltos[0] = colaFrames.poll();
            framesDevueltos[1] = colaFrames.poll();
        }
        return framesDevueltos;
    }
}
