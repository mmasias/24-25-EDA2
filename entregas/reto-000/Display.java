public class Display {
    private Frame buffer1;
    private Frame buffer2;
    private int frameActual;


    public Display(int frameActual) {
        this.frameActual = 0;
        buffer1 = new Frame(3, 7);
        buffer2 = new Frame(3, 7);
    }

    public void cambiarFrame() {
        if(frameActual == 0){
            frameActual=1;
        }else{
            frameActual=0;
        }
    }

    public String mostrarFrame() {

        String cadena = "";
        for (int i = 0; i < buffer1.getPixel().length; i++) {

            for (int j = 0; j < (buffer1.getPixel()[0].length)*2; j++) {
                if(j<buffer1.getPixel()[0].length){
                    cadena += buffer1.getPixel(i,j);
                }else{
                    cadena += buffer2.getPixel(i,j);
                }
            }
            cadena += "\n";
        }
        return cadena;
    }
}
