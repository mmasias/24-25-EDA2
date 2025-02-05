// Clase Pixel
public class Pixel {
    private char value;

    public Pixel(char value) {
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }
}

// Clase Frame
class Frame {
    private Pixel[][] pixels;
    private int x, y;

    public Frame(int x, int y) {
        this.x = x;
        this.y = y;
        this.pixels = new Pixel[x][y];
        initializePixels();
    }

    private void initializePixels() {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                pixels[i][j] = new Pixel(' '); // Valor por defecto
            }
        }
    }

    public Pixel getPixel(int x, int y) {
        return pixels[x][y];
    }

    public void setPixel(int x, int y, Pixel pixel) {
        pixels[x][y] = pixel;
    }
}

// Clase DataBase
class DataBase {
    private Frame[] frames;
    private Frame activeFrame;

    public DataBase(int numberOfFrames, int width, int height) {
        frames = new Frame[numberOfFrames];
        for (int i = 0; i < numberOfFrames; i++) {
            frames[i] = new Frame(width, height);
        }
        activeFrame = frames[0];
    }

    public void addFrame(Frame frame) {
        // Lógica para agregar un nuevo frame (simplificada)
    }

    public void switchFrame(int index) {
        if (index >= 0 && index < frames.length) {
            activeFrame = frames[index];
        }
    }

    public Frame getActiveFrame() {
        return activeFrame;
    }
}

// Clase Display
class Display {
    private Pixel[][] displayPixels;

    public Display(int width, int height) {
        displayPixels = new Pixel[width][height];
    }

    public void render() {
        for (int i = 0; i < displayPixels.length; i++) {
            for (int j = 0; j < displayPixels[i].length; j++) {
                if (displayPixels[i][j] != null) {
                    System.out.print(displayPixels[i][j].getValue() + " ");
                } else {
                    System.out.print(". "); // Representación vacía
                }
            }
            System.out.println();
        }
    }

    public void updateDataBase(DataBase db) {
        Frame frame = db.getActiveFrame();
        for (int i = 0; i < displayPixels.length; i++) {
            for (int j = 0; j < displayPixels[i].length; j++) {
                displayPixels[i][j] = frame.getPixel(i, j);
            }
        }
    }
}