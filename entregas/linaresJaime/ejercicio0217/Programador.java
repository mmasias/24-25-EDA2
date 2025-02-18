
public class Programador extends Empleado implements Trabajador {
    @Override
    public void trabajar() {
        System.out.println("Escribiendo código...");
    }
    
    public void depurarCodigo() {
        System.out.println("Depurando código...");
    }
}