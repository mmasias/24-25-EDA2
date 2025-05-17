package acta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

class Acta {
    private final List<Alumno> alumnos;

    public Acta(List<Alumno> alumnos) {
        this.alumnos = Collections.unmodifiableList(new ArrayList<>(alumnos));
    }

    public List<Alumno> getAlumnos() {
        return alumnos;
    }

    public Optional<Alumno> buscarAlumno(String nombre){
        return alumnos.stream()
                      .filter(name->name.getNombre().equalsIgnoreCase(nombre))
                      .findFirst();
    }

    public Nota recalcularPromedio(Alumno alumnoRecalc) {
        Nota original = alumnoRecalc.getNota();
        return new Nota(
            original.getParcial(), 
            original.getContinua(), 
            original.getNotaProfesor(),
            original.getExamenFinal()
        );
    }
}
