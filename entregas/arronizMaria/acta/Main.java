package acta;

import java.util.ArrayList;
import java.util.List;

class Main {
    public static void main(String[] args) {
        List<Alumno> alumnos = new ArrayList<>();
        alumnos.add(new Alumno("María", "Arroniz", new Nota(6.3, 7, 10, 7)));
        alumnos.add(new Alumno("Nazaret", "Deras", new Nota(7, 5, 10, 6)));
        alumnos.add(new Alumno("Juan", "Pérez", new Nota(4.5, 6.0, 5.5, 4.8)));
        alumnos.add(new Alumno("Ana", "Gómez", new Nota(9.0, 8.5, 9.0, 9.5)));
        alumnos.add(new Alumno("Luis", "Martínez", new Nota(3.5, 4.0, 3.8, 4.2)));

        Acta acta1 = new Acta(alumnos);

        List<Alumno> alumnosMod = new ArrayList<>(alumnos);
        alumnosMod.set(1, new Alumno("Nazaret", "Deras", new Nota(10, 10, 10, 10)));

        Acta acta2 = new Acta(alumnosMod);

        if (seModifico(acta1, acta2) == true) {
            System.out.println("Alguien toqueteó el acta");
        } else {
            System.out.println("El acta está intacta");
        }
    }

    private static boolean seModifico(Acta acta1, Acta acta2) {
        List<Alumno> lista1 = acta1.getAlumnos();
        List<Alumno> lista2 = acta2.getAlumnos();

        if (lista1.size() != lista2.size()) {
            return false;
        }

        for (int i = 0; i < lista1.size(); i++) {
            Alumno alumno1 = lista1.get(i);
            Alumno alumno2 = lista2.get(i);

            if (alumno1.getNombre() != alumno2.getNombre() || alumno1.getApellido() != alumno2.getApellido()) {
                return false;
            }

            Nota nota1 = alumno1.getNota();
            Nota nota2 = alumno2.getNota();

            if (nota1.getParcial() != nota2.getParcial() || 
                nota1.getContinua() != nota2.getContinua() ||
                nota1.getNotaProfesor() != nota2.getNotaProfesor() ||
                nota1.getExamenFinal() != nota2.getExamenFinal() || 
                nota1.getPromedio() != nota2.getPromedio()) {
                return false;
            }
        }

        return true;
    }

}
