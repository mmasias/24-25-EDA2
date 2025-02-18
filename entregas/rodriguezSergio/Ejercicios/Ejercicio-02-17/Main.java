public class Main {
    public static void main(String[] args) {
        Empleado albañil = new Albañil();
        Empleado arquitecto = new Arquitecto();
        Empleado jefeDeObra = new JefeDeObra();

        Empleado[] equipoConstruccion = {albañil, arquitecto, jefeDeObra};

        for (Empleado empleado : equipoConstruccion) {
            empleado.iniciarJornada();

            empleado.trabajar();

            empleado.realizarTareaEspecial();

            System.out.println("---");
        }
    }
}