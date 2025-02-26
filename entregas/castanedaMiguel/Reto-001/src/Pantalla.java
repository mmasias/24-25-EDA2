public class Pantalla {
    private Frame frameA;
    private Frame frameB;
    private int ancho;
    private int largo;

    private char[][] tabla;

    public Pantalla (Frame newFrameA, Frame newFrameB){

    }

    public void indicarTamaño(int ancho, int largo){
        this.ancho=ancho;
        this.largo=largo;
    }

    public void mostrar(){
        String sA;
        String sB;
        for(int i=largo-1;i>=0;i++){
            sA=new String(frameA.getPixeles(i));
            sB=new String(frameB.getPixeles(i));
            System.out.println(sA +sB);
        }
    }

    public void changePixel(int ancho, int largo, char pixel){

    }

    public void change(int largo, char[] pixeles){}

    public void mostrarColor(){


    }

    public void cambiarAlternancia(double tempo){

    }

    public void cambiarLatencia(double latencia){

    }



}

