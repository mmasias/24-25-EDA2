public class AscensorRecursivo {
    
    private int plantaActual;
    private int plantaDestino;
    private int estado; // 1 = subiendo, -1 = bajando, 0 = detenido

    public AscensorRecursivo(int plantaInicial) {
        this.plantaActual = plantaInicial;
        this.plantaDestino = 0;
        this.estado = 0;
    }

    // public void llamarAscensor(int plantaLlamada){

    // }

    public void pedirPlanta(int destino) {
        plantaDestino = destino;
        estado = Integer.compare(destino, plantaActual); // 1: sube, -1: baja, 0: detenido
        mover();
    }

    private void mover() {
        plantaActual += estado;
        System.out.println("Ascensor en planta: [" + plantaActual + "]");

        if ((plantaActual - plantaDestino) * estado != 0) {
            mover();
        } else {
            detener();
        }
    }

    private void detener() {
        estado = 0;
        System.out.println("Ascensor detenido en piso: " + plantaActual);
    }

    public static void main(String[] args) {
        AscensorRecursivo ascensor = new AscensorRecursivo(0);
        ascensor.pedirPlanta(5);
        System.out.println("Piden ascensor otra vez...");
        ascensor.pedirPlanta(-1);
    }
}
