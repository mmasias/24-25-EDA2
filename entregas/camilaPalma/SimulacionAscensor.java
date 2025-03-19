public class SimulacionAscensor {
    public static void main(String[] args) {
        Edificio edificio = new Edificio(7);
        Ascensor ascensor = new Ascensor(0);

        edificio.agregarPersona(0, 3);
        edificio.agregarPersona(1, 6);
        edificio.agregarPersona(4, 2);
        edificio.agregarPersona(5, 4);

        ascensor.agregarDestino(3);
        ascensor.agregarDestino(6);
        ascensor.agregarDestino(2);
        ascensor.agregarDestino(4);

        edificio.mostrarEstado(ascensor);
        edificio.moverAscensorRecursivo(ascensor);
    }
}
