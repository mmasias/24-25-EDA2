import java.util.Random;
import java.util.Scanner;

public class AscensorV2 {
    private int pisoActual;

    public AscensorV2() {
        this.pisoActual = 1;
    }

    public void moverAscensor(int destino) {
        Random random = new Random();
        boolean hayParadaIntermedia = random.nextBoolean();

        while (hayParadaIntermedia) {
            int pisoIntermedio = generarPisoIntermedio(destino);
            if (pisoIntermedio == -1) break;
            moverPiso(pisoIntermedio);
            hayParadaIntermedia = random.nextBoolean();
        }
        moverPiso(destino);
    }

    private int generarPisoIntermedio(int destino) {
        Random random = new Random();
        if (Math.abs(destino - pisoActual) <= 1) return -1;
        
        int pisoIntermedio;
        do {
            pisoIntermedio = random.nextInt(Math.abs(destino - pisoActual) - 1) + Math.min(destino, pisoActual) + 1;
        } while (pisoIntermedio == pisoActual || pisoIntermedio == destino);
        
        return pisoIntermedio;
    }

    private void moverPiso(int destino) {
        destino = (destino == -1) ? pisoActual : destino;
        int direccion = Integer.compare(destino, pisoActual);
        String mensaje = (direccion == 1) ? "\ud83d\udd3c Subiendo... " : "\ud83d\udd3d Bajando... ";

        switch (direccion) {
            case 1, -1 -> {
                pisoActual += direccion;
                System.out.println(mensaje + "Piso actual: " + pisoActual);
                moverPiso(destino);
            }
            default -> {
                abrirPuerta();
                System.out.println("\ud83d\udeaa Ascensor ha llegado al piso " + pisoActual);
                cerrarPuerta();
            }
        }
    }

    private void abrirPuerta() {
        System.out.println("\ud83d\udeaa Puerta abierta.");
    }

    private void cerrarPuerta() {
        System.out.println("\ud83d\udeaa Puerta cerrada.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AscensorV2 ascensor = new AscensorV2();

        System.out.print("\ud83c\udfe2 Ingrese el piso destino: ");
        int destino = scanner.nextInt();

        ascensor.moverAscensor(destino);
        scanner.close();
    }
}