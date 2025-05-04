package entregas.NevesKelvia.Ejercicio2;

class Alternancia {
    public void alternar(char[][] frame) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                frame[i][j] = frame[i][j] == '.' ? '#' : '.';
            }
        }
    }
    
    public void moverVertical(char[][] frame) {
        char[] temp = frame[2];
        for (int i = 2; i > 0; i--) {
            frame[i] = frame[i - 1];
        }
        frame[0] = temp;
    }
    
    public void timer() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

