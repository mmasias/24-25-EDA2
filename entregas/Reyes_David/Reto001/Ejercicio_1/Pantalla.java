package entregas.Reyes_David.Reto001.Ejercicio_1;

public class Pantalla {
    private DobleBuffer buffer;

    public Pantalla(DobleBuffer buffer) {
        this.buffer = buffer;
    }

    public void alternarResultados(int veces) {
        for (int i = 0; i < veces; i++) {
            buffer.mostrarFrame();
            System.out.println();
        }
    }

    public void alternarResultadosConTemporizador(int i, int j) {

        throw new UnsupportedOperationException("Unimplemented method 'alternarResultadosConTemporizador'");
    }
}
