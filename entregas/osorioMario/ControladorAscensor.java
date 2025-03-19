import java.util.LinkedList;
import java.util.List;

public class ControladorAscensor {
    private Ascensor ascensor;
    private List<Solicitud> solicitudes;  

    public ControladorAscensor(Ascensor ascensor) {
        this.ascensor = ascensor;
        this.solicitudes = new LinkedList<>();
    }

    public class Solicitud {
        private Piso pisoOrigen;
        private Piso pisoDestino;

        public Solicitud(Piso pisoOrigen, Piso pisoDestino) {
            this.pisoOrigen = pisoOrigen;
            this.pisoDestino = pisoDestino;
        }

        public Piso getPisoOrigen() {
            return pisoOrigen;
        }

        public Piso getPisoDestino() {
            return pisoDestino;
        }
    }

    public void agregarSolicitud(Piso pisoOrigen, Piso pisoDestino) {
        solicitudes.add(new Solicitud(pisoOrigen, pisoDestino));
    }

    public void atenderSolicitudes() {
        while (!solicitudes.isEmpty()) {
            Solicitud solicitud = solicitudes.remove(0); 
            Piso pisoOrigen = solicitud.getPisoOrigen();
            Piso pisoDestino = solicitud.getPisoDestino();

            System.out.println("Solicitud de: Piso " + pisoOrigen.getNumeroPiso() + " a Piso " + pisoDestino.getNumeroPiso());

            moverAscensor(pisoOrigen);

            moverAscensor(pisoDestino);
        }
    }

    private void moverAscensor(Piso pisoDestino) {
        while (ascensor.getPisoActual().getNumeroPiso() != pisoDestino.getNumeroPiso()) {
            if (ascensor.getPisoActual().getNumeroPiso() < pisoDestino.getNumeroPiso()) {
                ascensor.subir();
            } else {
                ascensor.bajar();
            }
        }
        System.out.println("El ascensor ha llegado al piso " + pisoDestino.getNumeroPiso());
    }
}
