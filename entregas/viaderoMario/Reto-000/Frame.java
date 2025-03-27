public class Frame {
    private Pixel [][] pixel;
    private int x;
    private int y;

    public Frame(int x, int y) {
        this.pixel= new Pixel[y][x];
        this.x = x;
        this.y = y;
    }

    public Pixel[][] getPixel() {
        return pixel;
    }


    public void setPixel(int x, int y, boolean estado, String color){
        pixel[y][x].setColor(color);
        pixel[y][x].setEstado(estado);
    }
    public Pixel getPixel(int x, int y){
        return pixel[y][x];
    }

    public void clearFrame(boolean estado, String color){
        for (int i = 0; i < pixel.length; i++) {
            for (int j = 0; j < pixel[i].length; j++) {
                pixel[y][x].setColor(color);
                pixel[y][x].setEstado(estado);
            }
        }
    }
}
