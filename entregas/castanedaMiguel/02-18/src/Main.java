public class Main {


    public static void main(String[] args) {
        Mazo mazo1= new Mazo();
        BarajaEspanola be=new BarajaEspanola();
        mazo1.barajar();
        be.barajar();

        mazo1 =be;
        mazo1.barajar();
        MazoYugioh my=new MazoYugioh();
        my.personalizar();

        Mazo mazoY=new MazoYugioh();
        mazoY.barajar();
    }
}