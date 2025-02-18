public class Frame {
    private char[][] pixeles;
    private int ancho;
    private int alto;

    public void print(){}
    public char[] getPixeles(int largo){
        if(largo>alto){
            return null;
        }
        char[] resultado=new char[ancho];
        for(int i=0; i<ancho;i++){
            resultado[i]=pixeles[i][largo];
        }

        return resultado;
    }

    public char getPixel(int ancho, int largo){
        if(largo>alto||ancho>this.ancho){
            return '\0';
        }

        return pixeles[ancho][largo];
    }
}