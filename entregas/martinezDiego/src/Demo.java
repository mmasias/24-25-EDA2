public class Demo {
    public static void main(String[] args) {
        Empleado desarrollador = new Desarrollador("Carlos", 2000, 3);
        Empleado gerente = new Gerente("Ana", 3000, 2);
        Empleado interno = new Interno("Luis", 1500);

        mostrarInformacionEmpleado(desarrollador);
        mostrarInformacionEmpleado(gerente);
        mostrarInformacionEmpleado(interno);
    }

    public static void mostrarInformacionEmpleado(Empleado empleado) {
        empleado.imprimirInformacion();
    }
}

