import java.util.*;

class Ascensor {
    int plantaActual;
    String direccion;
    List<Integer> destinos;
    List<Integer> personasEnAscensor;
    static final int CAPACIDAD = 1;

    public Ascensor(int plantaInicial) {
        this.plantaActual = plantaInicial;
        this.direccion = "STOP";
        this.destinos = new ArrayList<>();
        this.personasEnAscensor = new ArrayList<>();
    }

    public void agregarDestino(int destino) {
        if (!destinos.contains(destino)) {
            destinos.add(destino);
            Collections.sort(destinos);
        }
    }
}
