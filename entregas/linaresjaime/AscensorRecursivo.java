import java.util.Scanner;

public class AscensorRecursivo{

    public static void moverAscensor(int pisoActual, int pisoDestino) {
        if(pisoActual == pisoDestino) {
            System.out.println("El ascensor ha llegado al piso " + pisoDestino);
            return;
        }
        System.out.println("Piso actual: " + pisoActual);

        if (pisoActual < pisoDestino) {
            moverAscensor(pisoActual + 1, pisoDestino);
        } else {
            moverAscensor(pisoActual - 1, pisoDestino);
        }
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