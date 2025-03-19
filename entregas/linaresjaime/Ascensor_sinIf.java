import java.util.Scanner;

public class Ascensor_sinIf{

    public static void moverAscensor(int pisoActual, int pisoDestino) {
        int direccion = (pisoDestino - pisoActual) / Math.max(1, Math.abs(pisoDestino - pisoActual));

        while (pisoActual != pisoDestino) {
            System.out.println("Piso actual: " + pisoActual);
            pisoActual += direccion;
        }
        System.out.println("El ascensor ha llegado al piso " + pisoDestino);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el piso actual del ascensor: ");
        int pisoActual = scanner.nextInt();

        System.out.print("Ingrese el piso destino: ");
        int pisoDestino = scanner.nextInt();

        moverAscensor(pisoActual, pisoDestino);

        scanner.close();
    }
    
}