import java.util.Random;
import java.util.Scanner;

public class Ascensor {
    private int pisoActual;

    public Ascensor() {
        this.pisoActual = 1;
    }

    public void moverAscensor(int destino) {
        Random random = new Random();
        boolean hayParadaIntermedia = random.nextBoolean();

        if (hayParadaIntermedia) {
            int pisoIntermedio = random.nextInt(10) + 1;

            while (pisoIntermedio == pisoActual || pisoIntermedio == destino) {
                pisoIntermedio = random.nextInt(10) + 1;
            }

            System.out.println("📢 Otra persona llama al ascensor al piso " + pisoIntermedio);
            moverPiso(pisoIntermedio);
        }

        moverPiso(destino);
    }

    private void moverPiso(int destino) {
        if (pisoActual < destino) {
            subir(destino);
        } else if (pisoActual > destino) {
            bajar(destino);
        }
    }

    private void subir(int destino) {
        if (pisoActual == destino) {
            abrirPuerta();
            System.out.println("🚪 Ascensor ha llegado al piso " + pisoActual);
            cerrarPuerta();
            return;
        }
        pisoActual++;
        System.out.println("🔼 Subiendo... Piso actual: " + pisoActual);
        subir(destino);
    }

    private void bajar(int destino) {
        if (pisoActual == destino) {
            abrirPuerta();
            System.out.println("🚪 Ascensor ha llegado al piso " + pisoActual);
            cerrarPuerta();
            return;
        }
        pisoActual--;
        System.out.println("🔽 Bajando... Piso actual: " + pisoActual);
        bajar(destino);
    }

    private void abrirPuerta() {
        System.out.println("🚪 Puerta abierta.");
    }

    private void cerrarPuerta() {
        System.out.println("🚪 Puerta cerrada.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Ascensor ascensor = new Ascensor();

        System.out.print("🏢 Ingrese el piso destino: ");
        int destino = scanner.nextInt();

        ascensor.moverAscensor(destino);
        scanner.close();
    }
}