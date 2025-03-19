import java.util.Scanner;

public class Ascensor {
    private static final int PISO_MAXIMO = 20;
    private static final int PISO_MINIMO = 0;

    public static void manejarAscensor(int pisoActual, Scanner scanner) {
        System.out.println("El ascensor está en el piso: " + pisoActual);
        System.out.println("Ingrese el número de piso al que desea ir (" + PISO_MINIMO + " - " + PISO_MAXIMO + ") o 'salir': ");
        
        if (!scanner.hasNextInt()) {
            String entrada = scanner.next().toLowerCase();
            if (entrada.equals("salir")) {
                System.out.println("El ascensor se detiene en el piso: " + pisoActual);
                return;
            } else {
                System.out.println("Entrada no válida. Intente nuevamente.");
                manejarAscensor(pisoActual, scanner);
                return;
            }
        }
        
        int pisoDestino = scanner.nextInt();
        if (pisoDestino < PISO_MINIMO || pisoDestino > PISO_MAXIMO) {
            System.out.println("Piso fuera de rango. Intente nuevamente.");
        } else if (pisoDestino > pisoActual) {
            System.out.println("Subiendo...");
            pisoActual = pisoDestino;
        } else if (pisoDestino < pisoActual) {
            System.out.println("Bajando...");
            pisoActual = pisoDestino;
        } else {
            System.out.println("Ya estás en el piso solicitado.");
        }
        
        manejarAscensor(pisoActual, scanner);
    }
        
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el piso inicial del ascensor (entre " + PISO_MINIMO + " y " + PISO_MAXIMO + "): ");
        int pisoActual = scanner.nextInt();
        
        if (pisoActual < PISO_MINIMO || pisoActual > PISO_MAXIMO) {
            System.out.println("Piso fuera de rango. Iniciando en el piso " + PISO_MINIMO);
            pisoActual = PISO_MINIMO;
        }
        
        manejarAscensor(pisoActual, scanner);
        scanner.close();
    }
}
