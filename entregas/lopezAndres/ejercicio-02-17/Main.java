public class Main {
    public static void main(String[] args) {

        Vehiculo vehiculo1 = new Coche("Toyota");
        Vehiculo vehiculo2 = new Moto("Harley");
        Vehiculo vehiculo3 = new Camion("Volvo");

        vehiculo1.conducir();
        vehiculo2.conducir();
        vehiculo3.conducir();

        if (vehiculo1 instanceof Coche) {
            ((Coche) vehiculo1).revisarAceite();
        }

        Vehiculo[] flota = new Coche[3];
        flota[0] = new Coche("Honda");

        Coche cocheA = new Coche("Ford");
        Vehiculo vehiculoA = cocheA;
        System.out.println(cocheA.equals(vehiculoA));
    }
}
