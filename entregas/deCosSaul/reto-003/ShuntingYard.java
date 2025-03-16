import java.util.Scanner;

class ShuntingYard {

  public void iniciar() {
    System.out.println("Introduce la ecuacion que desea convertir:");
    String ecuacion = new Scanner(System.in).nextLine();
    System.out.println(convertir(ecuacion));
  }

  private String convertir(String ecuacion) {
    char[] salida = new char[ecuacion.length() * 2];
    char[] operadores = new char[ecuacion.length()];
    int indiceSalida = 0;
    int indiceOperadores = 0;

    for (int i = 0; i < ecuacion.length(); i++) {
      char caracterActual = ecuacion.charAt(i);

      if (Character.isDigit(caracterActual)) {
        salida[indiceSalida++] = caracterActual;
        if (i + 1 < ecuacion.length() && !Character.isDigit(ecuacion.charAt(i + 1))) {
          salida[indiceSalida++] = ' ';
        }
      } else if (caracterActual == '(') {
        operadores[indiceOperadores++] = caracterActual;
      } else if (caracterActual == ')') {
        while (indiceOperadores > 0 && operadores[indiceOperadores - 1] != '(') {
          salida[indiceSalida++] = operadores[--indiceOperadores];
          salida[indiceSalida++] = ' ';
        }
        indiceOperadores--;
      } else if (isOperator(caracterActual)) {
        while (indiceOperadores > 0 && precedence(caracterActual) <= precedence(operadores[indiceOperadores - 1])) {
          salida[indiceSalida++] = operadores[--indiceOperadores];
          salida[indiceSalida++] = ' ';
        }
        operadores[indiceOperadores++] = caracterActual;
      }
    }

    while (indiceOperadores > 0) {
      salida[indiceSalida++] = operadores[--indiceOperadores];
      salida[indiceSalida++] = ' ';
    }

    return new String(salida, 0, indiceSalida);
  }

  private boolean isOperator(char c) {
    return c == '+' || c == '-' || c == '*' || c == '/';
  }

  private int precedence(char operator) {
    switch (operator) {
      case '+':
      case '-':
        return 1;
      case '*':
      case '/':
        return 2;
      default:
        return -1;
    }
  }

  public static void main(String[] args) {
    new ShuntingYard().iniciar();
  }
}
