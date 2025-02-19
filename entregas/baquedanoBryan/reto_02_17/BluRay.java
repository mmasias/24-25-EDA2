package entregas.baquedanoBryan.reto_02_17;

public class BluRay extends CD {
    private String resolucion;

    public BluRay(String titulo, String artista, String resolucion) {
        super(titulo, artista);
        this.resolucion = resolucion;
    }

    @Override
    public void reproducir() {
        mostrarInfo();
        System.out.println("📀 Reproduciendo Blu-Ray en " + resolucion + " HD...");
    }

    public void mostrarResolucion() {
        System.out.println("Resolución del Blu-Ray: " + resolucion);
    }
}

