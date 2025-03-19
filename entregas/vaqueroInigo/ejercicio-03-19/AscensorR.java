import java.util.Scanner;

public class AscensorR {
    private int pisoActual;

    public AscensorR(int pisoInicial) {
        this.pisoActual = pisoInicial;
    }

    public void moverAscensor(int objetivo) {
        if (pisoActual == objetivo) {
            System.out.println("Estás en el piso " + pisoActual);
            return;
        }

        if (pisoActual < objetivo) {
            subir();
        } else {
            bajar();
        }

        moverAscensor(objetivo);
    }

    private void subir() {
        pisoActual++;
        System.out.println("Subiendo al piso " + pisoActual);
    }

    private void bajar() {
        pisoActual--;
        System.out.println("Bajando al piso " + pisoActual);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("¿En qué piso estás actualmente? ");
        int pisoInicial = scanner.nextInt();

        AscensorR ascensor = new AscensorR(pisoInicial);

        System.out.print("¿A qué piso quieres ir? ");
        int objetivo = scanner.nextInt();

        ascensor.moverAscensor(objetivo);

        scanner.close();
    }
}
