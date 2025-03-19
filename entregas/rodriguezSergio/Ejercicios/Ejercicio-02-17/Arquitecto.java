public class Arquitecto extends Empleado {
    @Override
    public void trabajar() {
        System.out.println("Arquitecto: Supervisando el diseño de la obra...");
    }

    @Override
    public void realizarTareaEspecial() {
        System.out.println("Arquitecto: Dibujando planos...");
    }
}