package entregas.baquedanoBryan.reto_02_17;

public class Cassette extends MedioFisico {
    public Cassette(String titulo, String artista) {
        super(titulo, artista);
    }

    @Override
    public void reproducir() {
        mostrarInfo();
        System.out.println("🎵 Sonido analógico con cinta magnética...");
    }

    @Override
    public void pausar() {
        System.out.println("Cassette en pausa... ⏸️");
    }

    @Override
    public void detener() {
        System.out.println("Cassette detenido. ⏹️ Rebobinando...");
    }
}

