
import java.util.Random;

public class Color {

    private char representacion;

    public Color(){

        switch(new Random().nextInt(4)+1){
            case 1:
                this.representacion = '.';
                break;
            case 2:
                this.representacion = '#';
                break;
            case 3:
                this.representacion = '+';
                break;
            case 4:
                this.representacion = '*';
                break;
        }

    }

    public char devolverRepresentacion(){
        return this.representacion;
    }
    
}