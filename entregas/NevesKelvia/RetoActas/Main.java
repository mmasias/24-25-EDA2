package entregas.NevesKelvia.RetoActas;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Persona alumno1 = new Persona("Ana Torres", "20241001");
        Persona alumno2 = new Persona("Luis Pérez", "20241002");
        Persona alumno3 = new Persona("María Gómez", "20241003");
        Persona alumno4 = new Persona("Carlos Ruiz", "20241004");
        Persona alumno5 = new Persona("Elena Díaz", "20241005");

        alumno1.asignarNotas(8, 8.5, 9);
        alumno2.asignarNotas(7, 7.5, 8);
        alumno3.asignarNotas(6, 6.5, 7);
        alumno4.asignarNotas(9, 9.5, 10);
        alumno5.asignarNotas(5, 5.5, 6);

        List<Persona> listaAlumnos = Arrays.asList(alumno1, alumno2, alumno3, alumno4, alumno5);

        Acta actaAsignatura = new Acta("Estructura de Datos", "2024-2025 Ordinaria", "Dr. López", listaAlumnos);

        actaAsignatura.generarActa(); 

        if (actaAsignatura.fueGenerada()) {
            System.out.println("Intentando cambiar nota de María Gómez...");
            alumno3.asignarNotas(10, 10, 10); 
        }

        actaAsignatura.verificarIntegridad();
    }
}
