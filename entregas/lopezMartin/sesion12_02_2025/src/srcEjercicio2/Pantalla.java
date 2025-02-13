package srcEjercicio2;
public class Pantalla{

    private Frame[] buffer;
    private Grafica grafica;
    private final char[][] tablaCombinaciones = new char[][]{
        {'.', '@', ':', ';'},  
        {'@', '#', '=', '&'},  
        {':', '=', '+', '$'},  
        {';', '&', '$', '*'}   
    };

    public Pantalla(){
        this.grafica = new Grafica();
        buffer = new Frame[2];
    }

    public void mostrar(){

        boolean ejecutando = true;

        while(ejecutando){

            grafica.generarFrames();

            buffer = grafica.devolverDosFrames();
            
            if(buffer[0]!=null && buffer[1]!=null){

                Pixel pixel1;
                Pixel pixel2;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {

                        pixel1 = buffer[0].devolverPixeles()[i][j];
                        pixel2 = buffer[1].devolverPixeles()[i][j];

                        char mezcla = mezclarColores(pixel1.devolverColor(), pixel2.devolverColor());

                        System.out.print(mezcla + " ");
                    }
                    System.out.println();
                }
                
            }else{
                System.out.println("No hay dos frames aún, espera");
            }
            pause();
        }
    }

    private static void pause() {
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
        }
    }

    private char mezclarColores(Color colorFrame1, Color colorFrame2) {
        int valorColor1 = colorFrame1.devolverValor()-1;
        int valorColor2 = colorFrame2.devolverValor()-1;
        return tablaCombinaciones[valorColor1][valorColor2];
    }

}