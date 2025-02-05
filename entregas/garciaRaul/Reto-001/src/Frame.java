public class Frame {
    private Pixel[][] pixeles;

    public Frame() {
        pixeles = new Pixel[3][7];
        rellenarPixeles();
    }

    private void rellenarPixeles() {
        for (int i = 0; i < pixeles.length; i++) {
            for (int j = 0; j < pixeles[i].length; j++) {
                pixeles[i][j] = new Pixel();
            }
        }
    }

    public Pixel[][] devolverPixeles() {
        return this.pixeles;
    }
}