
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GestorPantalla gestor = new GestorPantalla(7, 7, 2); 

        boolean salir = false;

        while (!salir) {
            System.out.println("Frame actual:");
            gestor.renderizar();

            System.out.println("Ingrese coordenadas (x y) y color, o -1 para cambiar de frame:");
            int x = scanner.nextInt();

            if (x == -1) {
                gestor.establecerPixel(new Coordenada(1, 1), 0); 
                continue; 
            }

            int y = scanner.nextInt();
            int color = scanner.nextInt();

            gestor.establecerPixel(new Coordenada(x, y), color);
        }

        scanner.close();
    }
}

