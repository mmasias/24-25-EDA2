package srcEjercicio1;
public class Pantalla{

    private Frame[] buffer;
    private Grafica grafica;

    public Pantalla(){
        this.grafica = new Grafica();
        buffer = new Frame[2];
    }

    public void mostrar(){

        grafica.generarFrames();

        while(true){
            buffer = grafica.devolverDosFrames();

            if(buffer[0]!=null && buffer[1]!=null){

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 7; j++) {
                        System.out.print(buffer[0].devolverPixeles()[i][j].devolverColor().devolverRepresentacion() + " ");
                    } 
                    for (int j = 0; j < 7; j++) {
                        System.out.print(buffer[1].devolverPixeles()[i][j].devolverColor().devolverRepresentacion() + " ");
                    }
                    System.out.println();
    
                }
            }else{
                System.out.println("a");
            }
        }
    }
}