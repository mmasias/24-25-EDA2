public class Empleado {
    public void iniciarJornada() {
        System.out.println("Inicio de jornada laboral");
    }

    public boolean equals(Object obj) {
        return obj instanceof Empleado;
    }
}
