import java.util.Scanner;

public class AscensorRecursivo {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    System.out.print("Ingresa el piso actual: ");
    int pisoActual = scanner.nextInt();

    System.out.print("Ingresa el piso destino: ");
    int pisoDestino = scanner.nextInt();

    moverAscensor(pisoActual, pisoDestino);

    scanner.close();
  }

  public static void moverAscensor(int actual, int destino) {
    if (actual == destino) {
      System.out.println("El ascensor ha llegado al piso " + destino);
      return;
    }

    System.out.println("Ascensor en el piso: " + actual);

    if (actual < destino) {
      moverAscensor(actual + 1, destino);
    } else {
      moverAscensor(actual - 1, destino);
    }
  }
}
