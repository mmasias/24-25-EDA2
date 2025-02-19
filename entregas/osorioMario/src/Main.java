public class Main {
    public static void main(String[] args) {
        Computadora pc1 = new Computadora();
        pc1.encender();

        Computadora pc2 = new Laptop();
        pc2.encender();

        Laptop laptop = new Laptop();
        Computadora pc4 = laptop;
        System.out.println(laptop.equals(pc4));

        Computadora[] equipos = new Laptop[3];
        equipos[0] = new Laptop();

        Computadora pc5 = new LaptopGaming();
        pc5.encender();

        if (pc5 instanceof LaptopGaming) {
            LaptopGaming gaming = (LaptopGaming) pc5;
            gaming.encender();
        }
    }
}
