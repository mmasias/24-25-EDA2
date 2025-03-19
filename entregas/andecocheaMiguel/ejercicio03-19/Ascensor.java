import java.util.Scanner;

public class Ascensor {
    private static final int PISO_MINIMO = 0;
    private static final int PISO_MAXIMO = 20;
    
    public static void moverAscensor(int pisoActual) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("El ascensor está en el piso " + pisoActual);
        System.out.print("Ingrese el piso destino (" + PISO_MINIMO + " - " + PISO_MAXIMO + "): ");
        int pisoDestino = scanner.nextInt();
        
        if (pisoDestino < PISO_MINIMO || pisoDestino > PISO_MAXIMO) {
            System.out.println("Error: Piso fuera de rango.");
            moverAscensor(pisoActual);
            return;
        }
        
        if (pisoActual == pisoDestino) {
            if (pisoActual == PISO_MAXIMO) {
                System.out.println("Has llegado al último piso. Fin del recorrido.");
            } else if (pisoActual == PISO_MINIMO) {
                System.out.println("Has llegado al primer piso. Fin del recorrido.");
            }
            System.out.println("El ascensor ya está en el piso " + pisoActual);
        } else if (pisoActual < pisoDestino) {
            System.out.println("Subiendo al piso " + (pisoActual + 1));
            moverAscensor(pisoActual + 1);
        } else {
            System.out.println("Bajando al piso " + (pisoActual - 1));
            moverAscensor(pisoActual - 1);
        }
        scanner.close();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el piso actual del ascensor (" + PISO_MINIMO + " - " + PISO_MAXIMO + "): ");
        int pisoActual = scanner.nextInt();
        
        if (pisoActual < PISO_MINIMO || pisoActual > PISO_MAXIMO) {
            System.out.println("Error: Piso fuera de rango.");
        } else {
            moverAscensor(pisoActual);
        }
        
        scanner.close();
    }
}
