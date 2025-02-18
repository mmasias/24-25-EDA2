
public class Main {
    public static void main(String[] args) {

        Empleado empleado = new Programador();
        empleado.iniciarJornada();

        if (empleado instanceof Programador) {
            ((Programador) empleado).depurarCodigo();
        }

        Empleado[] empleados = new Programador[3];
        empleados[0] = new Programador();

        empleados[1] = new Programador();

        Gerente gerente = new Gerente();
        gerente.trabajar();

        Empleado otroEmpleado = new Programador();
        System.out.println(empleado.equals(otroEmpleado));
    }
}
