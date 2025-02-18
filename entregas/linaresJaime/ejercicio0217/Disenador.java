
public class Disenador extends Empleado implements Trabajador {
    @Override
    public void trabajar() {
        System.out.println("Diseñando una nueva interfaz gráfica");
    }
    
    public void hacerBocetos() {
        System.out.println("Haciendo bocetos para la UI");
    }
}