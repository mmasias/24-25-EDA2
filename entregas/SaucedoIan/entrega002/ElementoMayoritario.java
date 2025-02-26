public class ElementoMayoritario {
  public static int encontrarElementoMayoritario(int[] numeros) {
    int candidato = numeros[0];
    int contador = 1;

    for (int i = 1; i < numeros.length; i++) {
      if (contador == 0) {
        candidato = numeros[i];
        contador = 1;
      } else if (numeros[i] == candidato) {
        contador++;
      } else {
        contador--;
      }
    }

    return validarMayoritario(numeros, candidato) ? candidato : -1;
  }

  private static boolean validarMayoritario(int[] numeros, int candidato) {
    int contador = 0;
    for (int numero : numeros) {
      if (numero == candidato)
        contador++;
    }
    return contador > numeros.length / 2;
  }

  private static void mostrarArreglo(int[] arreglo) {
    System.out.print("[");
    for (int i = 0; i < arreglo.length; i++) {
      System.out.print(arreglo[i]);
      if (i < arreglo.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] numeros = { 1, 1, 1, 1, 2, 2, 3 };
    System.out.println("Arreglo:");
    mostrarArreglo(numeros);

    int mayoritario = encontrarElementoMayoritario(numeros);
    if (mayoritario != -1) {
      System.out.println("Elemento mayoritario: " + mayoritario);
    } else {
      System.out.println("No hay elemento mayoritario");
    }
  }
}