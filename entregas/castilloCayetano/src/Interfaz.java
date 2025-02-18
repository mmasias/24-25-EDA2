import java.util.Scanner;

public class Interfaz {
    private Banco banco;
    private Usuario usuario;
    private Scanner scanner;

    public Interfaz() {
        banco = new Banco();
        usuario = new Usuario();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        while (true) {
            mostrarMenu();
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    crearCuenta();
                    break;
                case 2:
                    consultarSaldo();
                    break;
                case 3:
                    ingresarDinero();
                    break;
                case 4:
                    sacarDinero();
                    break;
                case 5:
                    eliminarCuenta();
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenu() {
        System.out.println("Seleccione una opción:");
        System.out.println("1. Crear cuenta");
        System.out.println("2. Consultar saldo");
        System.out.println("3. Ingresar dinero");
        System.out.println("4. Sacar dinero");
        System.out.println("5. Eliminar cuenta");
        System.out.println("6. Salir");
    }

    private void crearCuenta() {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        System.out.print("Ingrese el saldo inicial: ");
        double saldoInicial = scanner.nextDouble();
        scanner.nextLine();

        Cuenta cuenta = new Cuenta(numeroCuenta, saldoInicial);
        usuario.agregarCuenta(cuenta);
        System.out.println("Cuenta creada exitosamente");
    }

    private void consultarSaldo() {
        Cuenta cuenta = obtenerCuenta();
        if (cuenta != null) {
            banco.consultarSaldo(cuenta);
        }
    }

    private void ingresarDinero() {
        Cuenta cuenta = obtenerCuenta();
        if (cuenta != null) {
            System.out.print("Ingrese la cantidad a ingresar: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            banco.ingresarDinero(cuenta, cantidad);
        }
    }

    private void sacarDinero() {
        Cuenta cuenta = obtenerCuenta();
        if (cuenta != null) {
            System.out.print("Ingrese la cantidad a sacar: ");
            double cantidad = scanner.nextDouble();
            scanner.nextLine();
            banco.sacarDinero(cuenta, cantidad);
        }
    }

    private void eliminarCuenta() {
        Cuenta cuenta = obtenerCuenta();
        if (cuenta != null) {
            usuario.eliminarCuenta(cuenta);
            System.out.println("Cuenta eliminada exitosamente");
        }
    }

    private Cuenta obtenerCuenta() {
        System.out.print("Ingrese el número de cuenta: ");
        String numeroCuenta = scanner.nextLine();
        Cuenta cuenta = usuario.obtenerCuenta(numeroCuenta);
        if (cuenta == null) {
            System.out.println("Cuenta no encontrada");
        }
        return cuenta;
    }
}