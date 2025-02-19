public class Main {
  public static void main(String[] args) {
    Vehiculo vehiculo1 = new Vehiculo();
    vehiculo1.mover();

    Vehiculo vehiculo2 = new Bicicleta();
    vehiculo2.mover();

    Bicicleta bicicleta = (Bicicleta) vehiculo2;
    bicicleta.tocarTimbre();

    Vehiculo[] vehiculos = new Bicicleta[3];
    vehiculos[0] = new Bicicleta();

    Bicicleta bicicleta1 = new Bicicleta();
    Vehiculo vehiculo3 = bicicleta1;
    System.out.println(bicicleta1.equals(vehiculo3));

    BicicletaElectrica bicicletaElectrica = new BicicletaElectrica();
    bicicletaElectrica.mover();
  }
}
