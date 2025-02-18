public class Main {
    public static void main(String[] args) {
        Persona persona1 = new Persona("Juan", 25);
        Empleado empleado1 = new Empleado("Maria", 30, 70.0, 165, 'F', 9000, 50, 180, 10, "Recursos Humanos");

        System.out.println(persona1.toString());
        System.out.println(empleado1.toString());

        Persona persona2 = new Empleado("Pedro", 35, 75.0, 175, 'M', 12000, 60, 190, 15, "TI");

        if (persona2 instanceof Empleado) {
            Empleado emp = (Empleado) persona2;
            emp.trabajar();
        }

        Persona[] personas = new Empleado[2];
        personas[0] = new Empleado();

        if (persona2 instanceof Empleado) {
            System.out.println(persona2.getNombre() + " es un Empleado.");
        }

        Empleado emp1 = new Empleado("Carlos", 40, 80.0, 180, 'M', 15000, 65, 200, 20, "Ventas");
        Persona per1 = emp1;
        System.out.println(emp1.equals(per1));

        System.out.println(empleado1.toString());

        Trabajador trabajador = new Empleado();
        trabajador.trabajar();
    }
}
