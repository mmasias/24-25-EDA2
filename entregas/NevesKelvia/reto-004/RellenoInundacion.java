import java.util.Scanner;
import java.util.Stack;

public class RellenoInundacion {

    final static boolean MODO_DEBUG = false;
    
    public static void main(String[] args) {
        char[][] imagen = crearImagenEjemplo(PLANTILLA_001);
        imprimirImagen(imagen);
        System.out.println("Imagen original -- Pulse una tecla para empezar a pintarla");
        new Scanner(System.in).nextLine();
        
        char[] colores = {'o', 'x', '|', '\''};
        int colorIndex = 0;
        
        for (int y = 0; y < imagen.length; y++) {
            for (int x = 0; x < imagen[0].length; x++) {
                if (imagen[y][x] == '.') {
                    rellenarIterativo(imagen, x, y, colores[colorIndex % colores.length]);
                    colorIndex++;
                }
            }
        }
        
        imprimirImagen(imagen);
        System.out.println("Imagen después del relleno por inundación");
    }
    
    private static String[] PLANTILLA_001 = {
        ".....................................................",
        ".....................................................",
        "..########........#########.......########...........",
        "..#......#........#.......#.......#......#...........",
        "..#......#........#.......#.......#......#...........",
        "..#......#........#.......#.......#......#...........",
        "..########........#########.......########...........",
        ".....................................................",
        "..########....########....########....########.......",
        "..#......#....#......#....#......#....#......#.......",
        "..#......#....#......#....#......#....#......#.......",
        "..########....########....########....########.......",
        ".....................................................",
        "..#######.........#######.........#######............",
        "..#.....#.........#.....#.........#.....#............",
        "..#.....#.........#.....#.........#.....#............",
        "..#######.........#######.........#######............",
        ".....................................................",
        ".....................................................",
        "....................................................."
    };
    
    private static char[][] crearImagenEjemplo(String[] imagenOriginal) {
        int altura = imagenOriginal.length;
        int anchura = imagenOriginal[0].length();
        char[][] imagen = new char[altura][anchura];
        
        for (int y = 0; y < altura; y++) {
            imagen[y] = imagenOriginal[y].toCharArray();
        }
        return imagen;
    }
    
    public static void rellenarIterativo(char[][] imagen, int x, int y, char nuevoCaracter) {
        char caracterOriginal = imagen[y][x];
        if (caracterOriginal == nuevoCaracter) {
            return;
        }
        
        Stack<int[]> pila = new Stack<>();
        pila.push(new int[] { x, y });
        
        while (!pila.isEmpty()) {
            int[] coordenada = pila.pop();
            int actualX = coordenada[0];
            int actualY = coordenada[1];
            
            if (actualY < 0 || actualY >= imagen.length || actualX < 0 || actualX >= imagen[0].length) {
                continue;
            }
            
            if (imagen[actualY][actualX] != caracterOriginal) {
                continue;
            }
            
            imagen[actualY][actualX] = nuevoCaracter;
            
            pila.push(new int[] { actualX, actualY + 1 });
            pila.push(new int[] { actualX, actualY - 1 });
            pila.push(new int[] { actualX + 1, actualY });
            pila.push(new int[] { actualX - 1, actualY });
        }
    }
    
    public static void imprimirImagen(char[][] imagen) {
        cleanScreen();
        for (char[] fila : imagen) {
            System.out.println(new String(fila));
        }
        System.out.println();
    }
    
    static void cleanScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
