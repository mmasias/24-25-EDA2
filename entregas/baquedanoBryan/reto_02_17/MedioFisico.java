package entregas.baquedanoBryan.reto_02_17;

public abstract class MedioFisico implements Reproductor {
    protected String titulo;
    protected String artista;
    
    public MedioFisico(String titulo, String artista) {
        this.titulo = titulo;
        this.artista = artista;
    }

    public void mostrarInfo() {
        System.out.println("Reproduciendo: " + titulo + " - " + artista);
    }

    @Override
    public void detener() {
        System.out.println("Medio físico detenido. ");
    }
}
