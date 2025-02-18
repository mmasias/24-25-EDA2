public class Main {
    public static void main(String[] args) {
        Dispositivo[] dispositivos = new Dispositivo[3];
        dispositivos[0] = new Smartphone("Samsung");
        dispositivos[1] = new Laptop("Dell");
        dispositivos[2] = new Televisor("LG");

        for (Dispositivo dispositivo : dispositivos) {
            dispositivo.encender();

            if (dispositivo instanceof Smartphone) {
                ((Smartphone) dispositivo).hacerLlamada();
                ((Smartphone) dispositivo).conectarInternet();
            }

            if (dispositivo instanceof Laptop) {
                ((Laptop) dispositivo).conectarInternet();
            }

            System.out.println();
        }

        Laptop miLaptop = new Laptop("HP");
        miLaptop.mostrarInfo();

        Dispositivo laptop1 = new Laptop("Asus");
        Dispositivo laptop2 = new Laptop("Asus");
        System.out.println("¿Son iguales? " + laptop1.equals(laptop2));
    }
}
