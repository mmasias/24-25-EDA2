import java.util.Scanner;

public class AscensorUNEAtlantico {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ascensor UNEATLANTICO - Simulación Recursiva");
        System.out.print("Ingrese el piso actual (1-5): ");
        int pisoActual = scanner.nextInt();

        System.out.print("Ingrese el piso destino (1-5): ");
        int pisoDestino = scanner.nextInt();

        if (pisoActual < 1 || pisoActual > 5 || pisoDestino < 1 || pisoDestino > 5) {
            System.out.println("Error: El rango de pisos válidos es del 1 al 5.");
        } else if (pisoActual == pisoDestino) {
            System.out.println("Ya estás en el piso destino.");
        } else {
            moverAscensor(pisoActual, pisoDestino);
            System.out.println("Has llegado al piso " + pisoDestino + ".");
        }

        scanner.close();
    }

    
    public static void moverAscensor(int actual, int destino) {
        if (actual == destino) return;

        System.out.println("Ascensor en piso " + actual);

        if (actual < destino) {
            moverAscensor(actual + 1, destino); 
        } else {
            moverAscensor(actual - 1, destino); 
        }
    }
}
