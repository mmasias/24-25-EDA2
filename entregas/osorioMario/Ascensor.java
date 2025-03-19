public class Ascensor {
    private Piso pisoActual;

    public Ascensor(Piso pisoInicial) {
        this.pisoActual = pisoInicial;
    }

    public Piso getPisoActual() {
        return pisoActual;
    }

    public void subir() {
        this.pisoActual = new Piso(pisoActual.getNumeroPiso() + 1);
        System.out.println("El ascensor sube al piso " + pisoActual.getNumeroPiso());
    }

    public void bajar() {
        this.pisoActual = new Piso(pisoActual.getNumeroPiso() - 1);
        System.out.println("El ascensor baja al piso " + pisoActual.getNumeroPiso());
    }
}
