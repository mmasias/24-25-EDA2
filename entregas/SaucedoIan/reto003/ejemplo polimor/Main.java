public class Main {
  public static void main(String[] args) {
    System.out.println("\n=== DEMOSTRACIÓN DE INSTRUMENTOS MUSICALES ===\n");

    GuitarraElectrica guitarra = new GuitarraElectrica("Stratocaster", 1999.99, 6);
    PianoAnalogo piano = new PianoAnalogo("Steinway", 15999.99, 88, "Caoba");
    Sintetizador sinteti = new Sintetizador("Roland", 799.99, "Synth Wave");

    System.out.println("1. INSTRUMENTOS ELECTRÓNICOS");
    System.out.println("----------------------------");
    IElectronico[] instrumentosElectronicos = { guitarra, sinteti };
    for (IElectronico instrumento : instrumentosElectronicos) {
      System.out.println("\nProbando instrumento electrónico:");
      probarInstrumentoElectronico(instrumento);
    }
    System.out.println();

    System.out.println("2. FUNCIONES MUSICALES");
    System.out.println("----------------------");
    IMusical[] instrumentosMusicales = { guitarra, piano, sinteti };
    for (IMusical instrumento : instrumentosMusicales) {
      System.out.println("\nProbando instrumento musical:");
      probarInstrumentoMusical(instrumento);
    }
    System.out.println();

    System.out.println("3. INFORMACIÓN DE INSTRUMENTOS");
    System.out.println("-----------------------------");
    Instrumento[] instrumentos = { guitarra, piano, sinteti };
    for (Instrumento instrumento : instrumentos) {
      instrumento.mostrarInfo();
      System.out.println();
    }
  }

  private static void probarInstrumentoElectronico(IElectronico instrumento) {
    instrumento.conectar();
    instrumento.ajustarVolumen(8);
  }

  private static void probarInstrumentoMusical(IMusical instrumento) {
    instrumento.afinar();
    instrumento.tocar();
  }
}