package entregas.baquedanoBryan.reto_02_17;

public class MainErrores {
    public static void main(String[] args) {
        System.out.println("🔹 **Ejemplo de errores avanzados con herencia e interfaces** 🔹");

        MedioFisico[] coleccion = new CD[3];
        coleccion[0] = new Vinilo("Abbey Road", "The Beatles");

        BluRay miBluRay = new BluRay("The Dark Knight", "Hans Zimmer", "4K");
        CD miCD = miBluRay;
        miCD.mostrarResolucion();

        Reproductor miReproductor = new Digital("Random Access Memories", "Daft Punk");
        CD miCD2 = (CD) miReproductor;

        Object obj = new Cassette("Nevermind", "Nirvana");
        CD objCD = (CD) obj;

        MedioFisico medio = new CD("Meteora", "Linkin Park");
        Digital medioDigital = (Digital) medio;

        Reproductor[] listaReproductores = new Digital[2];
        listaReproductores[0] = new CD("A Night at the Opera", "Queen");

        Cassette miCassette = new Cassette("Back in Black", "AC/DC");
        miCassette = (Cassette) new BluRay("Interstellar", "Hans Zimmer", "4K");

        BluRay otroBluRay = new BluRay("Interstellar", "Hans Zimmer", "4K");
        System.out.println(otroBluRay);
    }
}

