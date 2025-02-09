
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
                    System.out.print("# ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Display display1 = new Display(5, 10);
        Display display2 = new Display(5, 10);

        for (int i = 0; i < display1.displayPixels.length; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < display1.displayPixels[i].length; j++) {
                    if (display1.displayPixels[i][j] != null) {
                        System.out.print(display1.displayPixels[i][j].getValue() + " ");
                    } else {
                        System.out.print("# ");
                    }
                }
            } else {
                System.out.print("  ");
                for (int j = 0; j < display2.displayPixels[i].length; j++) {
                    if (display2.displayPixels[i][j] != null) {
                        System.out.print(display2.displayPixels[i][j].getValue() + " ");
                    } else {
                        System.out.print("# ");
                    }
                }
            }
            System.out.println();
        }
    }
}
