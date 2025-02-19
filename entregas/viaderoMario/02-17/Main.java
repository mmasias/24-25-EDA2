public class Main {
    public static void main(String[] args) {

        Empleado empleado = new Cantante();
        empleado.iniciarJornada();

        if (empleado instanceof Cantante) {
            ((Cantante) empleado).escribirCancion();
        }

        Empleado[] empleados = new Cantante[3];
        empleados[0] = new Cantante();

        empleados[1] = new Cantante();

        Manager gerente = new Manager();
        gerente.trabajar();

        Empleado otroEmpleado = new Cantante();
        System.out.println(empleado.equals(otroEmpleado));
    }
}