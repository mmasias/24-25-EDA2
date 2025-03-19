import java.util.Scanner;

public class Ascensor{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el piso de destino: ");
        if (scanner.hasNextInt()) {
            int destino = scanner.nextInt();
            int pisoActual = 0; 
            System.out.println("Iniciando en el piso " + pisoActual);
            moverAscensor(pisoActual, destino);
        } else {
            System.out.println("Entrada inválida, ingrese un número entero.");
        }
        scanner.close();
    }

    public static void moverAscensor(int actual, int destino) {
        System.out.println("Piso actual: " + actual);
        if (actual == destino) {
            System.out.println("El ascensor ha llegado al piso " + actual);
            return;
        }
        if (actual < destino) {
            System.out.println("Subiendo al piso " + (actual + 1));
            moverAscensor(actual + 1, destino);
        } else {
            System.out.println("Bajando al piso " + (actual - 1));
            moverAscensor(actual - 1, destino);
        }
    }
}
