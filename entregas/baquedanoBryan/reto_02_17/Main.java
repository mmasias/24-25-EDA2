package entregas.baquedanoBryan.reto_02_17;

public class Main {
    public static void main(String[] args) {
        System.out.println(" **Ejemplo de referencias y polimorfismo** ");

        
        MedioFisico miCD = new CD("Back in Black", "AC/DC");
        miCD.reproducir(); 

        
        miCD.detener();

        System.out.println("\n **Ejemplo de instanceof y acceso a métodos específicos** ");

        if (miCD instanceof CD) {
            System.out.println("miCD es una instancia de CD.");
        }

        if (miCD instanceof MedioFisico) {
            System.out.println("miCD es una instancia de MedioFisico.");
        }

  
        BluRay miBluRay = new BluRay("The Wall", "Pink Floyd", "1080p");
        if (miBluRay instanceof BluRay) {
            miBluRay.mostrarResolucion();
        }

        System.out.println("\n **Ejemplo de covarianza en arrays** ");


        MedioFisico[] coleccion = new MedioFisico[3];
        coleccion[0] = new CD("Hybrid Theory", "Linkin Park");
        coleccion[1] = new BluRay("Interstellar Soundtrack", "Hans Zimmer", "4K");

        for (MedioFisico mf : coleccion) {
            if (mf != null) {
                mf.reproducir();
            }
        }

        System.out.println("\n **Interacción entre interfaces y herencia** ");

        Reproductor reproductor1 = new CD("A Night at the Opera", "Queen");
        Reproductor reproductor2 = new Digital("Smells Like teen spirit", "Nirvana");

        reproductor1.reproducir();
        reproductor2.reproducir();
    }
}
