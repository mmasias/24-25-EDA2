package entregas.martinezDiego.ejercicio0319;

public class Ascensor {

    public static void main(String[] args) {
        Ascensor ascensor = new Ascensor();
        ascensor.subir(5);
        ascensor.bajar(-7);
        ascensor.detener();
        
    }

    private int pisoActual;

    public Ascensor() {
        this.pisoActual = 0;
    }

    public void subir(int pisos) {
        if (pisos == 0) {
            System.out.println("Ascensor ha llegado al piso: " + pisoActual);
            return;
        }
        pisoActual++;
        System.out.println("Subiendo || Piso actual: " + pisoActual);
        subir(pisos - 1);
    }

    public void bajar(int pisos) {
        if (pisos == 0) {
            System.out.println("Ascensor ha llegado al piso: " + pisoActual);
            return;
        }
        pisoActual--;
        System.out.println("Bajando || Piso actual: " + pisoActual);
        bajar(pisos - (pisos > 0 ? 1 : -1));
    }

    public void detener() {
        System.out.println("Ascensor detenido en el piso: " + pisoActual);
    }

}
