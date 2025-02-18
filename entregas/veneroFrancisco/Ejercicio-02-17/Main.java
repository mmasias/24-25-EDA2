public class Main {
    public static void main(String[] args) {
        Transporte[] transportes = new Transporte[3];
        transportes[0] = new Conductor("Fran");
        transportes[1] = new Vehiculo("Coche");
        transportes[2] = new Pasajero("Carlos");

        for (Transporte transporte : transportes) {
            transporte.iniciar();

            if (transporte instanceof Conductor) {
                ((Conductor) transporte).iniciarRuta();
                ((Conductor) transporte).conducir();
            }

            if (transporte instanceof Vehiculo) {
                ((Vehiculo) transporte).repostar();
            }

            System.out.println();
        }

        Vehiculo miVehiculo = new Vehiculo("Motocicleta");
        miVehiculo.mostrarInfo();

        Transporte vehiculo1 = new Vehiculo("Autobús");
        Transporte vehiculo2 = new Vehiculo("Autobús");
        System.out.println("¿Son el mismo vehículo? " + vehiculo1.equals(vehiculo2));
    }
}