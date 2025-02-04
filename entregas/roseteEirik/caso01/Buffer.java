package entregas.roseteEirik.caso01;

public class Buffer {
    
    private Frame[] frames;
    private int timeout;
    private String[][] buffer;

    public Buffer(int width, int lenght,  int numberOfFrames, int timeout) {
        this.frames = new Frame[numberOfFrames];
        this.buffer = new String[width][lenght];
    }

    public void setFramePosition(int x, int y){
        for (int i = 0; i < frames.length; i++) {
            frames[i] = new Frame(x, y);
        }
    }

    public void updatePixel(int x, int y, String colour){
        buffer[x][y] = frames[0].changeColour(x, y, colour);
    }

    public void display(){
        for (int i = 0; i < buffer.length; i++) {
            for (int j = 0; j < buffer[i].length; j++) {
                System.out.print(buffer[i][j] + " ");
            }
            System.out.println();
        }
    }
}