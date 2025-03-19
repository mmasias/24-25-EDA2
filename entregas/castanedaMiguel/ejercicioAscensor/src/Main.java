public class Main {
    public static void main(String[] args) {

        int posicionActual=0;

        posicionActual=moverAscensor(5,posicionActual);

        posicionActual=moverAscensor(1,posicionActual);

        posicionActual=moverAscensor(9,posicionActual);

    }



    public static int moverAscensor(int planta, int posicionActual){

        System.out.println("Planta "+posicionActual);
        if(posicionActual>planta) {
            posicionActual = moverAscensor(planta, posicionActual - 1);
        }
        if(posicionActual<planta){
            posicionActual = moverAscensor(planta, posicionActual + 1);
        }

        return posicionActual;

    }
}

