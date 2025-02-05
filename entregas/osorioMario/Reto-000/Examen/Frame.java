public class Frame {
    private String[][] pixels;

    public Frame(int width, int height) {
        pixels = new String[width][height];
        fill("Negro"); // Inicializar con color negro
    }

    public void updatePixel(int x, int y, String color) {
        pixels[x][y] = color;
    }

    public void fill(String color) {
        for (int i = 0; i < pixels.length; i++) {
            for (int j = 0; j < pixels[i].length; j++) {
                pixels[i][j] = color;
            }
        }
    }

    public void display() {
        for (String[] row : pixels) {
            for (String pixel : row) {
                System.out.print(pixel.charAt(0) + " "); // Mostrar solo la inicial
            }
            System.out.println();
        }
        System.out.println();
    }
}
