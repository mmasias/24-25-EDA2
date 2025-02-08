public class Frame {
    
    private Pixel[][] pixeles;

    public Frame(){
        pixeles = new Pixel[3][7];
        rellenarPixeles();
    }

    public void rellenarPixeles(){
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 7; j++) {
                pixeles[i][j] = new Pixel();
            }
        }
    }

    public Pixel[][] devolverPixeles(){
        return this.pixeles;
    }
}
