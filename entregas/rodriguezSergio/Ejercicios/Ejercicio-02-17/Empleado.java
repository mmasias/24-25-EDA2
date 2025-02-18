public abstract class Empleado {
    public void iniciarJornada() {
        System.out.println("El empleado inicia su jornada en la obra");
    }

    public abstract void trabajar();

    public abstract void realizarTareaEspecial();

    @Override
    public boolean equals(Object otroEmpleado) {
        return otroEmpleado instanceof Empleado;
    }
}