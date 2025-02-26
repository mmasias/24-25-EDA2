package entregas.baquedanoBryan.reto_02_17;

public class Vinilo extends MedioFisico {
    public Vinilo(String titulo, String artista) {
        super(titulo, artista);
    }

    @Override
    public void reproducir() {
        mostrarInfo();
        System.out.println(" Sonido cálido y clásico con aguja...");
    }

    @Override
    public void pausar() {
        System.out.println("Aguja levantada. ");
    }

    @Override
    public void detener() {
        System.out.println("Vinilo detenido.  Aguja en reposo...");
    }
}

