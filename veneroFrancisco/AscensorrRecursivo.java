package veneroFrancisco;

import java.util.Scanner;

public class AscensorrRecursivo {

    public static void moverAscensor(int pisoActual, int pisoDestino) {
        if (pisoActual == pisoDestino) {
            System.out.println("El ascensor se ha detenido en el piso " + pisoDestino);
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

        System.out.print("Ingrese el piso de inicio: ");
        int pisoInicio = scanner.nextInt();

        System.out.print("Ingrese el piso de destino: ");
        int pisoDestino = scanner.nextInt();

        System.out.println("El ascensor comienza en el piso " + pisoInicio);
        moverAscensor(pisoInicio, pisoDestino);

        scanner.close();
    }
}
