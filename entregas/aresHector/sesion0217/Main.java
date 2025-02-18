public class Main {

    public static void main(String[] args) {

        Arma arma1 = new Pistola();
        arma1.disparar();
        Arma arma2 = new Rifle();
        arma2.disparar();

        Pistola pistola1 = new Pistola();
        pistola1.recargar();
        Rifle rifle1 = new Rifle();
        rifle1.apuntar();

        Arma[] armas = new Arma[3];
        armas[0] = new Pistola();
        armas[1] = new Rifle();
        armas[2] = new Pistola();

        if (rifle1 instanceof Rifle) {
            Rifle rifle = (Rifle) rifle1;
            rifle.apuntar();
        }

        Rifle rifle2 = new Rifle();
        Arma arma3 = rifle2;
        System.out.println(rifle2.equals(arma3));

        new RifleDePrecision().apuntar();

        new Pistola().disparar();

    }
}
