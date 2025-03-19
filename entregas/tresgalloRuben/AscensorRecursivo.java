
import java.util.Random;
import java.util.Scanner;

public class AscensorRecursivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pisoActual = 0; 
        int pisoDestino;

        System.out.println("Bienvenido al ascensor de la Universidad Europea del Atlántico");
        System.out.println("Ingrese el piso al que desea ir (-2 a 2): ");
        pisoDestino = scanner.nextInt();

        if (pisoDestino < -2 || pisoDestino > 2) {
            System.out.println("Piso no válido. Intente nuevamente.");
        } else {
            moverAscensor(pisoActual, pisoDestino, scanner, new Random());
            System.out.println("Ha llegado al piso " + pisoDestino);
        }

        scanner.close();
    }

    public static void moverAscensor(int actual, int destino, Scanner scanner, Random random) {
        if (actual == destino) {
            return;
        }

        if (actual < destino) {
            System.out.println("Subiendo al piso " + (actual + 1));
            actual++;
        } else {
            System.out.println("Bajando al piso " + (actual - 1));
            actual--;
        }

        boolean llamadaAleatoria = random.nextBoolean();
        if (llamadaAleatoria) {
            int nuevoDestino = random.nextInt(5) - 2; 
            System.out.println("Alguien ha llamado al ascensor en el piso " + actual + ". Nuevo destino: " + nuevoDestino);
            moverAscensor(actual, nuevoDestino, scanner, random);
        } else {
            moverAscensor(actual, destino, scanner, random);
        }
    }
}