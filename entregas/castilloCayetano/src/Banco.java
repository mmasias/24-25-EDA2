public class Banco {
    public void realizarOperacion() {
        System.out.println("Operación bancaria genérica");
    }

    public void ingresarDinero(Cuenta cuenta, double cantidad) {
        cuenta.ingresarDinero(cantidad);
        System.out.println("Ingresar " + cantidad + " dinero en la cuenta " + cuenta.getNumeroCuenta());
    }

    public void sacarDinero(Cuenta cuenta, double cantidad) {
        cuenta.sacarDinero(cantidad);
        System.out.println("Sacar " + cantidad + " dinero de la cuenta " + cuenta.getNumeroCuenta());
    }

    public void consultarSaldo(Cuenta cuenta) {
        System.out.println("El saldo de la cuenta " + cuenta.getNumeroCuenta() + " es " + cuenta.getSaldo());
    }
}