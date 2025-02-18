
public class Empleado {
    public void iniciarJornada() {
        System.out.println("El empleado inicia su jornada laboral");
    }
    
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Empleado;
    }
}
