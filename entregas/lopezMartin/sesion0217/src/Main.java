public class Main {

    public static void main(String[] args) {

        Telefono telefono1 = new Telefono();
        telefono1.recibirLlamada();
        Telefono samsung1 = new Samsung();
        samsung1.recibirLlamada();
 
        telefono1.llamar();
        telefono1.llamar("123456789");

        Samsung samsung2 = new Telefono();

        samsung1.abrirGalaxyStore();

        Telefono[] telefonos = new Samsung[5];
        telefonos[0] = new Samsung();
        telefonos[1] = samsung1;
        telefonos[2] = new Telefono();

        if (samsung1 instanceof Samsung) {
            Samsung samsung = (Samsung) samsung1;
            samsung.abrirGalaxyStore();
        }

        Samsung samsung3 = new Samsung();
        Telefono telefono2 = samsung3;
        System.out.println(samsung3.equals(telefono2));

        new SamsungEstropeado().abrirGalaxyStore();

        new Samsung().sacarFoto();

        
    }
    
}
