package entregas.baquedanoBryan.reto_02_17;

public class CD extends MedioFisico {
    public CD(String titulo, String artista) {
        super(titulo, artista);
    }

    @Override
    public void reproducir() {
        mostrarInfo();
        System.out.println("🎵 Sonido digital con lectura láser...");
    }

    @Override
    public void pausar() {
        System.out.println("CD en pausa... ⏸️");
    }

    @Override
    public void detener() {
        super.detener(); 
        System.out.println("CD detenido completamente. ⏹️");
    }
}

