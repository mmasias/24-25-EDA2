package entregas.NevesKelvia.Ejercicio2;

import java.util.Random;

class Frames {
    private char[][] frame1 = new char[3][4];
    private char[][] frame2 = new char[3][4];
    private char[] symbols = {'.', ',', '*', '+', ';', '#'};
    
    public Frames() {
        generateFrame(frame1);
        generateFrame(frame2);
    }
    
    private void generateFrame(char[][] frame) {
        Random rand = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                frame[i][j] = symbols[rand.nextInt(symbols.length)];
            }
        }
    }
    
    public char[][] getFrame1() {
        return frame1;
    }
    
    public char[][] getFrame2() {
        return frame2;
    }
}