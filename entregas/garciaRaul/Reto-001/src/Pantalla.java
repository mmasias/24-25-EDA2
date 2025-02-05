public class Pantalla {
    private Frame[] frames;
    private Grafica grafica;

    public void mostrar() {
        this.grafica = new Grafica();
        
        while (true) {
            frames = grafica.devolverDosFrames();
            if (frames != null) {
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(frames[0].devolverPixeles()[i][j].devolverColor().devolverRepresentacion() + " ");
                    }
                    System.out.print("  "); 
                    for (int j = 0; j < 7; j++) {
                        System.out.print(frames[1].devolverPixeles()[i][j].devolverColor().devolverRepresentacion() + " ");
                    }
                    System.out.println();
                }
                System.out.println();
                try {
                    Thread.sleep(1000 / 60); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}