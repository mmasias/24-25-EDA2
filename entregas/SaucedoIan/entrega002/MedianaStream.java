public class MedianaStream {
  private int[] numeros;
  private int tamanoActual;

  public MedianaStream(int capacidadMaxima) {
    numeros = new int[capacidadMaxima];
    tamanoActual = 0;
  }

  public void insertar(int numero) {
    int indice = tamanoActual;
    while (indice > 0 && numeros[indice - 1] > numero) {
      numeros[indice] = numeros[indice - 1];
      indice--;
    }
    numeros[indice] = numero;
    tamanoActual++;
  }

  public double obtenerMediana() {
    if (tamanoActual == 0)
      return 0;

    if (tamanoActual % 2 == 0) {
      int medio1 = numeros[(tamanoActual / 2) - 1];
      int medio2 = numeros[tamanoActual / 2];
      return (medio1 + medio2) / 2.0;
    } else {
      return numeros[tamanoActual / 2];
    }
  }

  private static void mostrarArreglo(int[] arreglo, int tamano) {
    System.out.print("[");
    for (int i = 0; i < tamano; i++) {
      System.out.print(arreglo[i]);
      if (i < tamano - 1)
        System.out.print(", ");
    }
    System.out.println("]");
  }

  public static void main(String[] args) {
    MedianaStream mediana = new MedianaStream(10);
    int[] flujo = { 1, 3, 2, 4, 5 };

    System.out.println("Procesando flujo de números:");
    for (int numero : flujo) {
      mediana.insertar(numero);
      System.out.println("Insertado: " + numero);
      System.out.print("Estado actual: ");
      mostrarArreglo(mediana.numeros, mediana.tamanoActual);
      System.out.println("Mediana: " + mediana.obtenerMediana());
      System.out.println();
    }
  }
}