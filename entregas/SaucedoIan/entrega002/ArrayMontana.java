import java.util.Random;

public class ArrayMontana {
  public static boolean esMontana(int[] numeros) {
    if (numeros.length < 3)
      return false;

    int i = 0;
    while (i < numeros.length - 1 && numeros[i] < numeros[i + 1]) {
      i++;
    }

    if (i == 0 || i == numeros.length - 1)
      return false;

    while (i < numeros.length - 1 && numeros[i] > numeros[i + 1]) {
      i++;
    }

    return i == numeros.length - 1;
  }

  private static int[] generarMontanaAleatoria(int tamano) {
    if (tamano < 3)
      tamano = 3;
    int[] montana = new int[tamano];
    Random random = new Random();

    int pico = tamano / 2;
    montana[pico] = 50;

    for (int i = pico - 1; i >= 0; i--) {
      montana[i] = montana[i + 1] - random.nextInt(5) - 1;
    }

    for (int i = pico + 1; i < tamano; i++) {
      montana[i] = montana[i - 1] - random.nextInt(5) - 1;
    }

    return montana;
  }

  private static void imprimirArreglo(int[] numeros) {
    System.out.print("[");
    for (int i = 0; i < numeros.length; i++) {
      System.out.print(numeros[i]);
      if (i < numeros.length - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    int[] montanaFija = { 1, 3, 5, 4, 2 };
    System.out.println("Arreglo montaña fijo:");
    imprimirArreglo(montanaFija);
    System.out.println("¿Es montaña? " + esMontana(montanaFija));

    int[] noMontana = { 1, 2, 3, 4, 5 };
    System.out.println("\nArreglo no montaña:");
    imprimirArreglo(noMontana);
    System.out.println("¿Es montaña? " + esMontana(noMontana));

    int[] montanaAleatoria = generarMontanaAleatoria(7);
    System.out.println("\nArreglo montaña aleatorio:");
    imprimirArreglo(montanaAleatoria);
    System.out.println("¿Es montaña? " + esMontana(montanaAleatoria));
  }
}