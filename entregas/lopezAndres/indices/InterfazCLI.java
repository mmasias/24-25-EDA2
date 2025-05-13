import java.util.Scanner;

public class InterfazCLI {
  private GestorCSV gestor;
  private Scanner scanner;

  public InterfazCLI() {
    this.gestor = new GestorCSV(100, 4);
    this.scanner = new Scanner(System.in);
  }

  private void mostrarMenu() {
    System.out.println("\n=== SISTEMA DE GESTIÓN DE ÍNDICES ===");
    System.out.println("1. Mostrar todos los datos");
    System.out.println("2. Crear índice simple");
    System.out.println("3. Crear índice ordenado");
    System.out.println("4. Buscar por índice");
    System.out.println("5. Mostrar valores únicos de columna");
    System.out.println("6. Buscar por rango");
    System.out.println("7. Ver valores ordenados");
    System.out.println("0. Salir");
    System.out.print("\nSeleccione una opción: ");
  }

  public void iniciar() {
    cargarDatosIniciales();
    boolean continuar = true;

    while (continuar) {
      mostrarMenu();
      int opcion = leerOpcion();

      switch (opcion) {
        case 1:
          mostrarDatos();
          break;
        case 2:
          crearIndice();
          break;
        case 3:
          crearIndiceOrdenado();
          break;
        case 4:
          buscarPorIndice();
          break;
        case 5:
          mostrarValoresUnicos();
          break;
        case 6:
          buscarPorRango();
          break;
        case 7:
          mostrarValoresOrdenados();
          break;
        case 0:
          continuar = false;
          break;
        default:
          System.out.println("Opción no válida");
      }
    }
    scanner.close();
  }

  private int leerOpcion() {
    try {
      return Integer.parseInt(scanner.nextLine());
    } catch (NumberFormatException e) {
      return -1;
    }
  }

  private void cargarDatosIniciales() {
    Cliente.cargarDatos(gestor);
    System.out.println("Datos cargados exitosamente.");
  }

  private void mostrarDatos() {
    gestor.imprimirDatos();
  }

  private void crearIndice() {
    System.out.print("Ingrese el nombre de la columna: ");
    String columna = scanner.nextLine();
    gestor.crearIndice(columna);
  }

  private void crearIndiceOrdenado() {
    System.out.print("Ingrese el nombre de la columna: ");
    String columna = scanner.nextLine();

    System.out.print("¿Orden descendente? (s/n): ");
    boolean descendente = scanner.nextLine().toLowerCase().startsWith("s");

    System.out.println("Algoritmos disponibles: quicksort, mergesort, heapsort");
    System.out.print("Seleccione el algoritmo: ");
    String algoritmo = scanner.nextLine().toLowerCase();

    gestor.crearIndiceOrdenado(columna, descendente, algoritmo);
  }

  private void buscarPorIndice() {
    System.out.print("Ingrese el nombre de la columna: ");
    String columna = scanner.nextLine();

    System.out.print("Ingrese el valor a buscar: ");
    String valor = scanner.nextLine();

    String[][] resultado = gestor.buscarPorIndice(columna, valor);
    imprimirResultado(resultado);
  }

  private void mostrarValoresUnicos() {
    System.out.print("Ingrese el nombre de la columna: ");
    String columna = scanner.nextLine();

    String[] valores = gestor.obtenerValoresUnicos(columna);
    System.out.println("\nValores únicos en " + columna + ":");
    for (String valor : valores) {
      System.out.println(valor);
    }
  }

  private void buscarPorRango() {
    System.out.print("Ingrese el nombre de la columna ordenada: ");
    String columna = scanner.nextLine();

    if (!gestor.estaIndexada(columna)) {
      System.out.println("La columna no está indexada o no está ordenada");
      return;
    }

    System.out.print("Valor inicial del rango: ");
    String valorInicial = scanner.nextLine();

    System.out.print("Valor final del rango: ");
    String valorFinal = scanner.nextLine();

    IndiceOrdenado indice = (IndiceOrdenado) gestor.obtenerIndice(columna);
    BuscadorBinario buscador = new BuscadorBinario(indice);
    int[] posiciones = buscador.buscarRango(valorInicial, valorFinal);

    System.out.println("\nResultados encontrados: " + posiciones.length);
    for (int pos : posiciones) {
      for (int j = 0; j < gestor.getColumnas(); j++) {
        System.out.print(gestor.getDato(pos, j) + "\t");
      }
      System.out.println();
    }
  }

  private void mostrarValoresOrdenados() {
    System.out.print("Ingrese el nombre de la columna: ");
    String columna = scanner.nextLine();

    if (!gestor.estaIndexada(columna)) {
      System.out.println("La columna no está indexada");
      return;
    }

    Cliente.mostrarValoresOrdenados(gestor, columna);
  }

  private void imprimirResultado(String[][] resultado) {
    if (resultado.length == 0) {
      System.out.println("No se encontraron resultados");
      return;
    }

    System.out.println("\nResultados encontrados:");
    for (String[] fila : resultado) {
      for (String valor : fila) {
        System.out.print(valor + "\t");
      }
      System.out.println();
    }
  }
}
