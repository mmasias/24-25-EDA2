class Main {
  public static void main(String[] args) {

    int[] resultado = sumaObjetivo(new int[] { 3, 2, 9, 8 }, 10);
    System.out.println("Indices: " + resultado[0] + " " + resultado[1]);

    resultado = busquedaPalabra(new char[] { 'a', 'c', 'd', 'i', 'm', 'r', 't', 'u' }, "dia");
    System.out.println("Indices: " + resultado[0] + " " + resultado[1] + " " + resultado[2]);

    numeroFaltante(new int[] { 1, 2, 4, 5, 6 });

    System.out.println(montana(new int[] { 1, 3, 5, 4, 2 }));

    System.out.println(puntoDeEquilibrio(new int[] { 1, 2, 3, 4, 6 }));

    System.out.println(elementoMayoritario(new int[] { 3, 2, 2, 2, 4 }));

    System.out.println(productoDefectuoso(new boolean[] { false, false, false, true, true }));

    System.out.println(arrayRotado(new int[] { 4, 5, 6, 1, 2, 3, }));
  }

  private static int[] sumaObjetivo(int[] numeros, int objetivo) {

    for (int i = 0; i < numeros.length; i++) {
      for (int j = 0; j < numeros.length; j++) {
        if (numeros[i] + numeros[j] == objetivo) {
          return new int[] { i, j };
        }
      }
    }
    return null;
  }

  private static int[] busquedaPalabra(char[] caracteres, String palabra) {
    int[] indices = new int[palabra.length()];
    for (int i = 0; i < palabra.length(); i++) {
      char c = palabra.charAt(i);
      boolean found = false;
      for (int j = 0; j < caracteres.length; j++) {
        if (caracteres[j] == c) {
          indices[i] = j;
          found = true;
          break;
        }
      }
      if (!found) {
        return null;
      }
    }
    return indices;
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

  private static int productoDefectuoso(boolean[] elementos) {

    int indice = -1;
    boolean defectuoso = false;

    while (!defectuoso) {
      indice++;
      defectuoso = elementos[indice] == true ? true : false;
    }
    return indice;

  }

  public static int arrayRotado(int[] numeros) {
    int izquierda = 0;
    int derecha = numeros.length - 1;

    while (izquierda < derecha) {
      int medio = izquierda + (derecha - izquierda) / 2;
      if (numeros[medio] > numeros[derecha]) {
        izquierda = medio + 1;
      } else {
        derecha = medio;
      }
    }

    return izquierda;
  }
}
