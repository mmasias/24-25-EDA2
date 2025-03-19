package entregas.gutierrezMarcos;

public class Ascensor {

    int planta = 0;
    int destino = 0;

    public void mover(int actual) {
        System.out.println("Ascensor en planta: " + actual);

        if (actual == destino) {
            System.out.println("Llegamos a la planta " + destino);
            return;
        }

        if (actual < destino) {
            mover(actual + 1);
        } else {
            mover(actual - 1);
        }
    }

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        ascensor.destino = 5;
        ascensor.mover(ascensor.planta);
    }
}