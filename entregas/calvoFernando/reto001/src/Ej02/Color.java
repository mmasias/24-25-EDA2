package Ej02;

import java.util.Random;

public class Color {

    private char representacion;
    private int valor;

    public Color(){

        switch(new Random().nextInt(4)+1){
            case 1:
                this.representacion = '.';
                this.valor = 1;
                break;
            case 2:
                this.representacion = '#';
                this.valor = 2;
                break;
            case 3:
                this.representacion = '+';
                this.valor = 3;
                break;
            case 4:
                this.representacion = '*';
                this.valor = 4;
                break;
        }

    }

    public char devolverRepresentacion(){
        return this.representacion;
    }

    public int devolverValor(){
        return this.valor;
    }

}

