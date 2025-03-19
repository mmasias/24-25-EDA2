import java.util.*;

class Edificio {
    int numPlantas;
    List<Integer>[] personasEsperando;

    @SuppressWarnings("unchecked")
    public Edificio(int numPlantas) {
        this.numPlantas = numPlantas;
        this.personasEsperando = new ArrayList[numPlantas];

        for (int i = 0; i < numPlantas; i++) {
            this.personasEsperando[i] = new ArrayList<>();
        }
    }

    public void agregarPersona(int planta, int destino) {
        personasEsperando[planta].add(destino);
    }

    public void mostrarEstado(Ascensor ascensor) {
        System.out.println();
        for (int i = numPlantas - 1; i >= 0; i--) {
            System.out.printf("Planta %d    ", i);
            System.out.printf("___%d_  ", personasEsperando[i].size());

            if (ascensor.plantaActual == i) {
                System.out.printf("  |[%s]|  ", ascensor.personasEnAscensor.size());
            } else {
                System.out.print("  |  |  ");
            }

            System.out.printf("  __%d__", personasEsperando[i].size());
            System.out.println();
        }
        System.out.println("         /--------- Ascensores ------/");
    }

    public void moverAscensorRecursivo(Ascensor ascensor) {
        if (ascensor.destinos.isEmpty()) {
            System.out.println("\nEl ascensor ha completado su recorrido.");
            return;
        }

        int destino = ascensor.destinos.get(0);
        if (ascensor.plantaActual < destino) {
            ascensor.direccion = "UP";
            ascensor.plantaActual++;
        } else if (ascensor.plantaActual > destino) {
            ascensor.direccion = "DOWN";
            ascensor.plantaActual--;
        } else {
            ascensor.destinos.remove(0);
            ascensor.personasEnAscensor.removeIf(p -> p == ascensor.plantaActual);

            subirPersonas(ascensor, ascensor.plantaActual);
        }
        mostrarEstado(ascensor);
        moverAscensorRecursivo(ascensor);
    }

    private void subirPersonas(Ascensor ascensor, int planta) {
        Iterator<Integer> iter = personasEsperando[planta].iterator();
        while (iter.hasNext() && ascensor.personasEnAscensor.size() < Ascensor.CAPACIDAD) {
            int destino = iter.next();
            ascensor.personasEnAscensor.add(destino);
            ascensor.agregarDestino(destino);
            iter.remove();
        }
    }
}
