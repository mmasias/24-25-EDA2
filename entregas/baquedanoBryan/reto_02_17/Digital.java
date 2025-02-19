package entregas.baquedanoBryan.reto_02_17;

public class Digital implements Reproductor {
    private String titulo;
    private String artista;

    public Digital(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    @Override
    public void reproducir() {
        System.out.println(" Reproduciendo en streaming: " + titulo + " - " + artista);
    }

    @Override
    public void pausar() {
        System.out.println("Reproducción digital en pausa. ");
    }

    @Override
    public void detener() {
        System.out.println("Reproducción digital detenida. ");
    }
}
