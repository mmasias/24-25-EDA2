class Gerente extends Empleado {
    private int equiposGestionados;

    public Gerente(String nombre, double salarioBase, int equiposGestionados) {
        super(nombre, salarioBase);
        this.equiposGestionados = equiposGestionados;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (equiposGestionados * 1000);
    }
}

