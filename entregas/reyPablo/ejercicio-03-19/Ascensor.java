import java.util.Scanner;

public class Ascensor {
    public static void moverAscensor(int pisoActual, int pisoDestino) {
        if (pisoActual == pisoDestino) {
            System.out.println("El ascensor ha llegado al piso " + pisoActual + ".");
            return;
        }
        System.out.println("El ascensor está en el piso " + pisoActual + ".");
        if (pisoActual < pisoDestino) {
            System.out.println("Subiendo al siguiente piso...");
            moverAscensor(pisoActual + 1, pisoDestino);
        } 
        else {
            System.out.println("Bajando al siguiente piso...");
            moverAscensor(pisoActual - 1, pisoDestino);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el piso de inicio: ");
        int pisoInicio = scanner.nextInt();
        
        System.out.print("Ingrese el piso de destino: ");
        int pisoDestino = scanner.nextInt();
        moverAscensor(pisoInicio, pisoDestino);
        scanner.close();
    }
}
