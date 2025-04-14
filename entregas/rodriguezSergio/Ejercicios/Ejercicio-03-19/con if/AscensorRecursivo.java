import java.util.Scanner;

public class AscensorRecursivo {

    public static void moverAscensor(int actual, int destino) {
        if (actual == destino) {
            System.out.println("El ascensor ha llegado a la planta " + destino);
            return;
        }

        int diferencia = (destino > actual) ? (destino - actual) : (actual - destino);

        if (actual < destino) {
            System.out.println("El ascensor tiene que subir " + diferencia + " " + (diferencia == 1 ? "planta" : "plantas"));
        } else {
            System.out.println("El ascensor tiene que bajar " + diferencia + " " + (diferencia == 1 ? "planta" : "plantas"));
        }

        System.out.println("Está en la planta " + actual);
        System.out.println("---------------");

        moverAscensor(actual + (actual < destino ? 1 : -1), destino);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int plantaActual, plantaDestino;

        System.out.print("Ingrese la planta actual: ");
        plantaActual = scanner.nextInt();

        do {
            System.out.print("Ingrese la planta destino: ");
            plantaDestino = scanner.nextInt();

            if (plantaActual == plantaDestino) {
                System.out.println("Ya está en esa planta, ingrese una diferente.");
            }
        } while (plantaActual == plantaDestino);

        moverAscensor(plantaActual, plantaDestino);
        scanner.close();
    }
}