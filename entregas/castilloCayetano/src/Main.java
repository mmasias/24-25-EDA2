public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        banco.realizarOperacion();

        Banco cajero = new Cajero();
        cajero.realizarOperacion();

        Banco aplicacion = new Aplicacion();
        aplicacion.realizarOperacion();


        Interfaz interfaz = new Interfaz();
        interfaz.iniciar();
    }
}
