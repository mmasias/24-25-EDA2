import java.awt.Color;
import java.awt.Graphics;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class RellenoInundacionColor extends JFrame {

    private static final int CELL_SIZE = 20;
    private static char[][] imagen;
    private final TableroPanel panel;

    public RellenoInundacionColor(boolean pixelPorPixel) {
        setTitle("Relleno Inundación - Visualización en Tiempo Real");
        setSize(imagen[0].length * CELL_SIZE + 16, imagen.length * CELL_SIZE + 39);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
        panel = new TableroPanel();
        add(panel);
        setVisible(true);
    
        if (pixelPorPixel) {
            new Thread(() -> pintarZonasEnTiempoReal()).start();
        } else {
            pintarZonasDirectamente();
            panel.repaint();
        }
    }

    public static String[] PLANTILLA_001 = {
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


private void pintarZonasEnTiempoReal() {
    char caracterActual = 'a';
    for (int y = 0; y < imagen.length; y++) {
        for (int x = 0; x < imagen[0].length; x++) {
            if (imagen[y][x] == '.') {
                rellenarRecursivo(imagen, x, y, caracterActual, '.', true); // Activar tiempo real
                caracterActual++;
                if (caracterActual > 'z') {
                    caracterActual = 'A';
                }
            }
        }
    }
}

private void pintarZonasDirectamente() {
    char caracterActual = 'a';
    for (int y = 0; y < imagen.length; y++) {
        for (int x = 0; x < imagen[0].length; x++) {
            if (imagen[y][x] == '.') {
                rellenarRecursivo(imagen, x, y, caracterActual, '.', false); // Desactivar tiempo real
                caracterActual++;
                if (caracterActual > 'z') {
                    caracterActual = 'A';
                }
            }
        }
    }
}

private void rellenarRecursivo(char[][] imagen, int x, int y, char nuevoCaracter, char caracterOriginal, boolean tiempoReal) {

    if (y < 0 || y >= imagen.length || x < 0 || x >= imagen[0].length) {
        return;
    }

    if (imagen[y][x] != caracterOriginal || caracterOriginal == nuevoCaracter) {
        return;
    }

    imagen[y][x] = nuevoCaracter;

    if (tiempoReal) {
        panel.repaint();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    rellenarRecursivo(imagen, x + 1, y, nuevoCaracter, caracterOriginal, tiempoReal);
    rellenarRecursivo(imagen, x - 1, y, nuevoCaracter, caracterOriginal, tiempoReal);
    rellenarRecursivo(imagen, x, y + 1, nuevoCaracter, caracterOriginal, tiempoReal);
    rellenarRecursivo(imagen, x, y - 1, nuevoCaracter, caracterOriginal, tiempoReal);
}

    private class TableroPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int y = 0; y < imagen.length; y++) {
                for (int x = 0; x < imagen[0].length; x++) {
                    g.setColor(getColor(imagen[y][x]));
                    g.fillRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                    g.setColor(Color.BLACK);
                    g.drawRect(x * CELL_SIZE, y * CELL_SIZE, CELL_SIZE, CELL_SIZE);
                }
            }
        }

        private Color getColor(char c) {
            switch (c) {
                case 'a': return Color.RED;
                case 'b': return Color.GREEN;
                case 'c': return Color.BLUE;
                case 'd': return Color.YELLOW;
                case 'e': return Color.MAGENTA;
                case 'f': return Color.CYAN;
                case 'g': return Color.ORANGE;
                case 'h': return Color.PINK;
                case 'i': return Color.GRAY;
                case 'j': return Color.LIGHT_GRAY;
                case '#': return Color.DARK_GRAY;
                case '.': return Color.WHITE;
                default: return new Color((c * 1234567) % 256, (c * 654321) % 256, (c * 987654) % 256); // Generar colores únicos
            }
        }
    }
    

    public static void main(String[] args) {
    imagen = RellenoInundacionColor.crearImagenEjemplo(RellenoInundacionColor.PLANTILLA_001);

    System.out.println("Seleccione el modo de pintado:");
    System.out.println("1. Pintar todo directamente");
    System.out.println("2. Pintar pixel por pixel");
    Scanner scanner = new Scanner(System.in);
    int opcion = scanner.nextInt();

    if (opcion == 1) {
        new RellenoInundacionColor(false);
    } else if (opcion == 2) {
        new RellenoInundacionColor(true);
    } else {
        System.out.println("Opción no válida. Saliendo...");
    }
    scanner.close();
}

    private static char[][] crearImagenEjemplo(String[] plantilla) {
        char[][] imagen = new char[plantilla.length][plantilla[0].length()];
        for (int i = 0; i < plantilla.length; i++) {
            imagen[i] = plantilla[i].toCharArray();
        }
        return imagen;
    }
}