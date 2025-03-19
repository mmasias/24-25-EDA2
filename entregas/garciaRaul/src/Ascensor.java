import java.util.Scanner;

public class Ascensor {
    private static int pisoActual = 0;
    private static final int PISO_MAX = 5;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ascensor en piso " + pisoActual);
        simularAscensor(sc);
        sc.close();
    }
    
    private static void simularAscensor(Scanner sc) {
        System.out.print("Ingrese piso destino (0-" + PISO_MAX + ") o -1 para salir: ");
        int destino = sc.nextInt();
        
        if (destino == -1) return;
        
        if (destino >= 0 && destino <= PISO_MAX) {
            moverAscensor(destino);
        } else {
            System.out.println("Piso inválido");
        }
        
        simularAscensor(sc); 
    }
    
    private static void moverAscensor(int destino) {
        if (pisoActual == destino) {
            System.out.println("Llegó al piso " + destino);
            return;
        }
        
        if (pisoActual < destino) {
            pisoActual++;
            System.out.println("Subiendo... Piso " + pisoActual);
        } else {
            pisoActual--;
            System.out.println("Bajando... Piso " + pisoActual);
        }
        
        moverAscensor(destino); 
    }
}