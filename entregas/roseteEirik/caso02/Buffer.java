package entregas.roseteEirik.caso02;

public class Buffer {
    
    private int timeout;
    private String[][] buffer;

    public Buffer(int width, int lenght,  int numberOfFrames, int timeout) {
        this.buffer = new String[width][lenght];
    }

    public void updatePixel(int x, int y, String colour){
        buffer[x][y] = colour;
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