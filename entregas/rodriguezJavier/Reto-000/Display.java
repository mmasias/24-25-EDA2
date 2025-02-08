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
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }
}