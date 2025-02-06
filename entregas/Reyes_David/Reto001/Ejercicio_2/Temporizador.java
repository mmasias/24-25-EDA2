package entregas.Reyes_David.Reto001.Ejercicio_2;

public class Temporizador {
    public void alternarFrames(DobleBuffer buffer, Pantalla pantalla, int iteraciones) throws InterruptedException {
        for (int i = 0; i < iteraciones; i++) {
            pantalla.mostrar(buffer.getFrame1());
            Thread.sleep(500);
            pantalla.mostrar(buffer.getFrame2());
            Thread.sleep(500);
        }
    }
}
