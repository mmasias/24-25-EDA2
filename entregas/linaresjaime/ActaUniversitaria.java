package entregas.linaresjaime;

import java.util.Scanner;

public class ActaUniversitaria {
    static TablaHash tabla = new TablaHash();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        cargarAlumnos();

        int opcion;
        do {
            System.out.println("\n--- Sistema de Actas Universitarias ---");
            System.out.println("1. Ver lista de alumnos");
            System.out.println("2. Editar notas de un alumno");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    tabla.mostrarTodos();
                    break;
                case 2:
                    editarAlumno();
                    break;
                case 3:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 3);
    }

    static void editarAlumno() {
        System.out.print("Introduce el DNI del alumno: ");
        String dni = sc.nextLine();

        Alumno alumno = tabla.buscar(dni);

        if (alumno != null) {
            System.out.println("Alumno encontrado:");
            alumno.mostrarDatos();

            System.out.print("Nueva nota parcial: ");
            alumno.notaParcial = sc.nextDouble();

            System.out.print("Nueva nota final: ");
            alumno.notaFinal = sc.nextDouble();

            alumno.calcularNotaGlobal();

            System.out.println("Notas actualizadas correctamente.");
            alumno.mostrarDatos();
        } else {
            System.out.println("Alumno no encontrado.");
        }
    }

    static void cargarAlumnos() {
        tabla.insertar(new Alumno("11111111A", "Alba Lahoz", 8.5, 9.0));
        tabla.insertar(new Alumno("22222222B", "Carlos Gómez", 6.0, 7.5));
        tabla.insertar(new Alumno("33333333C", "Lucía Fernández", 9.0, 9.5));
        tabla.insertar(new Alumno("44444444D", "Mario Rodríguez", 5.5, 6.5));
        tabla.insertar(new Alumno("55555555E", "Nerea Martín", 7.0, 7.8));
        tabla.insertar(new Alumno("66666666F", "Iván Torres", 4.0, 5.5));
        tabla.insertar(new Alumno("77777777G", "Clara Vázquez", 8.0, 8.2));
        tabla.insertar(new Alumno("88888888H", "Marcos Sánchez", 6.8, 7.1));
        tabla.insertar(new Alumno("99999999I", "Sara Morales", 9.5, 9.0));
        tabla.insertar(new Alumno("10101010J", "Hugo Díaz", 3.5, 5.0));
    }
}
