import java.util.Scanner;

public class AscensorRecursivo {

    public static void moverAscensor(int actual, int destino) {
        if (actual == destino) {
            System.out.println("El ascensor ha llegado a la planta " + destino);
            return;
        }

        System.out.println("El ascensor está en la planta " + actual);

        moverAscensor(actual + ((actual < destino) ? 1 : -1), destino);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantaActual, plantaDestino;

        System.out.print("Ingrese la planta actual: ");
        plantaActual = scanner.nextInt();

        System.out.print("Ingrese la planta destino: ");
        while ((plantaDestino = scanner.nextInt()) == plantaActual) {
            System.out.println("Ya está en esa planta, ingrese una diferente.");
            System.out.print("Ingrese la planta destino: ");
        }

        moverAscensor(plantaActual, plantaDestino);
        scanner.close();
    }
}

