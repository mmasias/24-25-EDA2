import java.util.Scanner;

public class AscensorSinIf {
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
        
        
        boolean continuar = destino != -1;
        boolean pisoValido = destino >= 0 && destino <= PISO_MAX;
        
        
        boolean moverAscensor = continuar && pisoValido;
        
        switch(String.valueOf(moverAscensor)) {
            case "true":
                moverAscensor(destino);
                break;
            case "false":
                
                System.out.println(continuar ? "Piso inválido" : "");
                break;
        }
        
        
        int siguientePaso = continuar ? 1 : 0;
        switch(siguientePaso) {
            case 1:
                simularAscensor(sc);
                break;
        }
    }
    
    private static void moverAscensor(int destino) {
        
        boolean llegado = pisoActual == destino;
        
        switch(String.valueOf(llegado)) {
            case "true":
                System.out.println("Llegó al piso " + destino);
                return;
            case "false":
                
                int direccion = pisoActual < destino ? 1 : -1;
                pisoActual += direccion;
            
              System.out.println(direccion > 0 ? "Subiendo... Piso " + pisoActual 