package ejercicios.Reyes_david.Ejercicio_2;

import java.util.LinkedList;
import java.util.Queue;
public class ListaCircularFrames {
    private Queue<Frame> frames;
    public ListaCircularFrames(int tamaño, Dimension dimension) {
        frames = new LinkedList<>();
        for (int i = 0; i < tamaño; i++) {
            frames.add(new Frame(dimension));
        }
    }
    public Frame obtenerActual() { Frame f = frames.poll(); frames.offer(f); return f; }
}