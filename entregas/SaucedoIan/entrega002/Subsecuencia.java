public class Subsecuencia {
  public static boolean esSubsecuencia(String s, String t) {
    if (s.length() == 0)
      return true;
    if (t.length() == 0)
      return false;

    int indiceS = 0;
    int indiceT = 0;

    while (indiceT < t.length()) {
      if (s.charAt(indiceS) == t.charAt(indiceT)) {
        indiceS++;
        if (indiceS == s.length())
          return true;
      }
      indiceT++;
    }

    return false;
  }

  private static void mostrarResultado(String s, String t, boolean esSubsecuencia) {
    System.out.println("s = \"" + s + "\"");
    System.out.println("t = \"" + t + "\"");
    System.out.println("Es subsecuencia: " + esSubsecuencia);
  }

  public static void main(String[] args) {
    String s = "abc";
    String t = "ahbgdc";

    System.out.println("Prueba 1:");
    mostrarResultado(s, t, esSubsecuencia(s, t));

    System.out.println("\nPrueba 2:");
    mostrarResultado("axc", "ahbgdc", esSubsecuencia("axc", "ahbgdc"));
  }
}