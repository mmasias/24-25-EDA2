import java.util.Scanner;

class Frame {
    private Pixel[][] pixeles;
    private int width;
    private int height;

    public Frame(int width, int height){
        this.width = width;
        this.height = height;
        this.pixeles = new Pixel[height][width];

        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                pixeles[x][y] = new Pixel(0);
            }
        }
    }

    public void updatePixel(Pixel[][] pixeles){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coordenadas del pixel que quiere modificar:?");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        System.out.println("Valor nuevo: (Negro: · Blanco: # Cyan: + Magenta: *)?");
        int value = scanner.nextInt();

        pixeles[x][y].setValue(value);
    }

    public void deletePixel(Pixel[][] pixeles){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Coordenadas del pixel que quiere eliminar (volver a negro):?");
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int value = 0;

        pixeles[x][y].setValue(value);
    }

    public void setPixel(int x, int y, int value){
        pixeles[x][y].setValue(value);

    }

    public Pixel getPixel(int x, int y) {
        return pixeles[x][y];
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void printFrame() {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                System.out.print(pixeles[x][y].getValue() + "\t");
            }
            System.out.println();
        }
    }

}
