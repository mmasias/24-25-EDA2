package entregas.lopezMartin.retoHashing;

public class Ejemplo {

    public static void main(String[] args) {

        Estudiante[] estudiantes = new Estudiante[]{
            new Estudiante("Juan", "Pérez", 4.5, 6.0, 5.5, 4.8),
            new Estudiante("Ana", "Gómez", 9.0, 8.5, 9.0, 9.5),
            new Estudiante("Luis", "Martínez", 3.5, 4.0, 3.8, 4.2),
            new Estudiante("María", "López", 7.2, 6.8, 7.0, 6.5),
            new Estudiante("Carlos", "Sánchez", 5.5, 6.2, 5.8, 6.0),
        };

        ActaEDA2 acta = new ActaEDA2(estudiantes);
        System.out.println("Código del acta: " + acta.getCodigoActa());

        String codigoOriginal = acta.getCodigoActa();

        estudiantes[0] = new Estudiante("Juan", "Pérez", 10.0, 10.0, 10.0, 10.0);

        ActaEDA2 actaModificada = new ActaEDA2(estudiantes);
        String codigoModificado = actaModificada.getCodigoActa();
        System.out.println("Código del nuevo acta: " + codigoModificado);

        if (!codigoOriginal.equals(codigoModificado)) {
            System.out.println("El acta ha sido modificada");
        } else {
            System.out.println("El acta no ha sido modificada");
        }

    }
    
}
