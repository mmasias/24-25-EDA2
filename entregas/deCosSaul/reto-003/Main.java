class Main {
  public static void main(String[] args) {

    numeroFaltante(new int[] { 1, 2, 4, 5, 6 });

    System.out.println(montana(new int[] { 1, 3, 5, 4, 2 }));

    System.out.println(puntoDeEquilibrio(new int[] { 1, 2, 3, 4, 6 }));

    System.out.println(elementoMayoritario(new int[] { 3, 2, 2, 2, 4 }));
  }

  private static void sumaObjetivo(int[] numeros, int objetivo) {

  }

  private static void busquedaPalabra(int[] numeros, int objetivo) {

  }

  private static void numeroFaltante(int[] numeros) {

    for (int i = 1; i < numeros.length - 1; i++) {
      if ((numeros[i] + 1) != numeros[i + 1]) {
        System.out.println("Salida: " + (numeros[i] + 1));
      }
    }

  }

  private static boolean montana(int[] numeros) {

    int indice = 0;
    boolean creciendo = true;
    boolean decreciendo = false;

    while (creciendo) {
      if (indice + 1 == numeros.length) {
        return true;
      }
      if (numeros[indice + 1] > numeros[indice]) {
      } else {
        creciendo = false;
        decreciendo = true;
      }
      indice++;
    }

    while (decreciendo) {
      if (indice + 1 == numeros.length) {
        return true;
      }
      if (numeros[indice + 1] > numeros[indice]) {
        return false;
      }
      indice++;
    }
    return true;
  }

  private static int puntoDeEquilibrio(int[] numeros) {
    int indice = 1;
    int sumaIzquierda;
    int sumaDerecha;
    while (indice < numeros.length) {
      sumaIzquierda = 0;
      sumaDerecha = 0;

      for (int i = 0; i < indice; i++) {
        sumaIzquierda += numeros[i];
      }
      for (int j = indice + 1; j < numeros.length; j++) {
        sumaDerecha += numeros[j];
      }
      if (sumaIzquierda == sumaDerecha) {
        return indice;
      }
      indice++;

    }
    return 0;
  }

  private static int elementoMayoritario(int[] numeros) {

    int candidato = numeros[0];
    int contador = 1;

    for (int i = 1; i < numeros.length; i++) {
      if (contador == 0) {
        candidato = numeros[i];
        contador = 1;
      } else if (candidato == numeros[i]) {
        contador++;
      } else {
        contador--;
      }
    }

    contador = 0;
    for (int num : numeros) {
      if (num == candidato) {
        contador++;
      }
    }

    if (contador > numeros.length / 2) {
      return candidato;
    }
    return -1;
  }
}
