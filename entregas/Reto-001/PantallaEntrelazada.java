public class PantallaEntrelazada {
    private int ancho;
    private int alto;
    private ListaCircularFrames listaFrames;
    
    public PantallaEntrelazada(int ancho,int alto){
        this.ancho=ancho;
        this.alto=alto;
        listaFrames = new ListaCircularFrames(ancho, alto, 0);
    }

    public void establecerPixel(Coordenada coordenada, int color,int frame){
        listaFrames.obtenerFrame(frame).establecerPixel(coordenada, color);
     
    }
    public void renderizar(){
        char[][]combinacion={

            {'.','@',':',';'},
            {'@','#','=','&'},
            {':','=','+','$'},
            {';','&','$','*'}



        };

        Pixel[][] f1 = listaFrames.obtenerFrame(0).getPixeles();
        Pixel[][] f2 = listaFrames.obtenerFrame(1).getPixeles();

        for (int i = 0; i < f1.length; i++) {
            for (int j = 0; j < f1[i].length; j++) {
                Pixel p1 = listaFrames.obtenerFrame(0).obtenerPixel(new Coordenada(i, j));
                Pixel p2 = listaFrames.obtenerFrame(1).obtenerPixel(new Coordenada(i, j));
                System.out.print(combinacion[p1.obtenerColor()][p2.obtenerColor()]);
            }
            System.out.println();
            
        }
    }
    
}
