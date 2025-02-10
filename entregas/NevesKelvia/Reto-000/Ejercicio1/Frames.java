package entregas.NevesKelvia.Ejercicio1;

class Frames {
    char[][] frames;

    Frames() {
        frames = new char[][] {
            {'.', '+', '*', '#', '.', '+', '*'},
            {'#', '*', '.', '+', '#', '*', '.'},
            {'+', '.', '#', '*', '+', '.', '#'}
        };
    }

    void frame1() {
        System.out.println("Frame 1:");
        for (char[] row : frames) {
            for (char pixel : row) {
                System.out.print(pixel + " ");
            }
            System.out.println();
        }
    }

    void frame2() {
        System.out.println("Frame 2:");
        for (int i = frames.length - 1; i >= 0; i--) {
            for (int j = frames[i].length - 1; j >= 0; j--) {
                System.out.print(frames[i][j] + " ");
            }
            System.out.println();
        }
    }
}
