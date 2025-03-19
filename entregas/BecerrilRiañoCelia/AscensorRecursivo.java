package BecerrilRiañoCelia;

public class AscensorRecursivo {

    private static final int PLANTA_MINIMA = -3;
    private static final int PLANTA_MAXIMA = 3;

    private int plantaActual;
    private int personasEnAscensor;
    private int capacidadMaxima;
    private boolean puertaAbierta;

    public AscensorRecursivo(int capacidadMaxima) {
        this.plantaActual = 0;
        this.personasEnAscensor = 0;
        this.capacidadMaxima = capacidadMaxima;
        this.puertaAbierta = false;
    }

    public boolean subirRecursivo(int plantaDestino) {

        if (plantaActual == plantaDestino) {
            System.out.println("Ya estamos en la planta " + plantaDestino);
            return true;
        }

        cerrarPuerta();

        plantaActual++;
        System.out.println("Subiendo... Ahora en planta " + plantaActual);

        return subirRecursivo(plantaDestino);
    }

    public boolean bajarRecursivo(int plantaDestino) {

        if (plantaActual == plantaDestino) {
            System.out.println("Ya estamos en la planta " + plantaDestino);
            return true;
        }

        cerrarPuerta();

        plantaActual--;
        System.out.println("Bajando... Ahora en planta " + plantaActual);

        return bajarRecursivo(plantaDestino);
    }

    public boolean moverAPlantaRecursivo(int plantaDestino) {

        if (plantaDestino > plantaActual) {
            return subirRecursivo(plantaDestino);
        } else if (plantaDestino < plantaActual) {
            return bajarRecursivo(plantaDestino);
        } else {
            System.out.println("Ya estamos en la planta " + plantaDestino);
            return true;
        }
    }

    public int subirPersonasRecursivo(int cantidad, int personasSubidas, int[] destinos) {

        if (personasSubidas >= cantidad || personasEnAscensor >= capacidadMaxima) {
            return personasSubidas;
        }

        abrirPuerta();

        personasEnAscensor++;
        System.out.println("Persona subió al ascensor. Total: " + personasEnAscensor);

        cerrarPuerta();
        moverAPlantaRecursivo(destinos[personasSubidas]);

        return subirPersonasRecursivo(cantidad, personasSubidas + 1, destinos);
    }

    public int bajarPersonasRecursivo(int cantidad, int personasBajadas) {

        if (personasBajadas >= cantidad || personasEnAscensor <= 0) {
            return personasBajadas;
        }

        abrirPuerta();

        personasEnAscensor--;
        System.out.println("Persona bajó del ascensor. Quedan: " + personasEnAscensor);

        return bajarPersonasRecursivo(cantidad, personasBajadas + 1);
    }

    public void abrirPuerta() {
        if (!puertaAbierta) {
            puertaAbierta = true;
            System.out.println("Puerta abierta");
        }
    }

    public void cerrarPuerta() {
        if (puertaAbierta) {
            puertaAbierta = false;
            System.out.println("Puerta cerrada");
        }
    }

    public int getPlantaActual() {
        return plantaActual;
    }

    public int getPersonasEnAscensor() {
        return personasEnAscensor;
    }

    public static void main(String[] args) {
        AscensorRecursivo ascensor = new AscensorRecursivo(8);

        System.out.println("=== SIMULACIÓN DE ASCENSOR RECURSIVO ===");

        int[] destinos = {2, 3, -1};
        ascensor.subirPersonasRecursivo(3, 0, destinos);

        ascensor.bajarPersonasRecursivo(1, 0);

        ascensor.moverAPlantaRecursivo(3);

        ascensor.moverAPlantaRecursivo(-2);

        ascensor.bajarPersonasRecursivo(ascensor.getPersonasEnAscensor(), 0);

    }
}