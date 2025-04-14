public class Cajero extends Banco {
    @Override
    public void realizarOperacion() {
        System.out.println("Operación en el cajero");
    }

    @Override
    public void ingresarDinero(Cuenta cuenta, double cantidad) {
        super.ingresarDinero(cuenta, cantidad);
    }

    @Override
    public void sacarDinero(Cuenta cuenta, double cantidad) {
        super.sacarDinero(cuenta, cantidad);
    }
}