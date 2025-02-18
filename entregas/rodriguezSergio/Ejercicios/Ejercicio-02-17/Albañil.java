public class Albañil extends Empleado {
    @Override
    public void trabajar() {
        System.out.println("Albañil: Construyendo paredes...");
    }

    @Override
    public void realizarTareaEspecial() {
        System.out.println("Albañil: Reparando una pared dañada...");
    }
}
