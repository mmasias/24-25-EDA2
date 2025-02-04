package entregas.roseteEirik.caso03;

public class Frame {
    
    private int width;
    private int height;
    private Pixel[][] pixels;

    public Frame(int width, int height) {
        this.width = width;
        this.height = height;
        this.pixels = new Pixel[width][height];
    }

    public String changeColour(int x, int y, String colour){
        this.pixels[x][y] = new Pixel(colour);

        return colour;
    }
}
