public class Aplicacion extends Banco {
    @Override
    public void realizarOperacion() {
        System.out.println("Operación en la aplicación");
    }

    @Override
    public void consultarSaldo(Cuenta cuenta) {
        super.consultarSaldo(cuenta);
    }
}