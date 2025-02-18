public class Empleado extends Persona implements Trabajador {
    private double sueldo;
    private double valorHora;
    private double horasTrabajadas;
    private double horasExtras;
    private String departamento;

    public static final int HORAS_LEGALES = 180;
    public static final double SUELDO_MINIMO = 470;

    public Empleado() {
        this("Oscar", 18, 80.5, 180, 'M', 15000, 50, 200, 20, "Informatica");
    }

    public Empleado(String nombre, int edad, double pesoKg, int alturaCm, char genero,
            double sueldo, double valorHora, double horasTrabajadas, double horasExtras, String departamento) {
        super(nombre, edad, pesoKg, alturaCm, genero);
        this.sueldo = sueldo;
        this.valorHora = valorHora;
        this.horasTrabajadas = horasTrabajadas;
        this.horasExtras = horasExtras;
        this.departamento = departamento;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    public double getHorasTrabajadas() {
        return horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Empleado " + super.toString() +
                String.format(", Sueldo: %.2f, ValorHora: %.2f, HorasTrabajadas: %.2f, Departamento: %s",
                        sueldo, valorHora, horasTrabajadas, departamento);
    }

    @Override
    public void trabajar() {
        System.out.println(getNombre() + " está trabajando en el departamento de " + departamento);
    }
}
