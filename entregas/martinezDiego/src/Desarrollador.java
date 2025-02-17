class Desarrollador extends Empleado {
    private int proyectosCompletados;

    public Desarrollador(String nombre, double salarioBase, int proyectosCompletados) {
        super(nombre, salarioBase);
        this.proyectosCompletados = proyectosCompletados;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (proyectosCompletados * 500);
    }
}

