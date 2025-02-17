package Ejercicio1702;

public class Principal {
    public static void main(String[] args) {
        Coche bmw = new Coche("BMW", 0, 4);
        Moto ducati = new Moto("Ducati", 0, 1100);

        bmw.acelerar();
        ducati.acelerar();

        bmw.frenar();
        ducati.frenar();

        Vehiculo[] vehiculos = new Vehiculo[2];
        vehiculos[0] = bmw;
        vehiculos[1] = ducati;

        System.out.println("\nMostrando información de los vehículos:");
        for (Vehiculo v : vehiculos) {
            System.out.println(v);

            if (v instanceof Electrico) {
                ((Electrico) v).cargarBateria();

            }
        }

        Coche otroBMW = new Coche("BMW2", 10, 4);
        System.out.println("\nComparando vehículos:");
        System.out.println("¿El primer BMW y el otro BMW son iguales? " + bmw.equals(otroBMW));
    }
}
