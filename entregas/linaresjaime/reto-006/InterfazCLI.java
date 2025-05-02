import java.util.ArrayList;

import java.util.List;
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
        System.out.println("7. Comparar algoritmos de ordenación");
        System.out.println("8. Probar algoritmo específico");
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
                    compararAlgoritmos();
                    break;
                case 8:
                    probarAlgoritmoEspecifico();
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

        if (resultado.length == 0) {
            System.out.println("\nNo se encontraron resultados exactos para '" + valor + "'");

            String[] valoresUnicos = gestor.obtenerValoresUnicos(columna);
            List<String> sugerencias = new ArrayList<>();

            for (String v : valoresUnicos) {
                if (v.toLowerCase().contains(valor.toLowerCase())) {
                    sugerencias.add(v);
                }
            }

            if (!sugerencias.isEmpty()) {
                System.out.println("\n¿Quizás quisiste decir alguno de estos?");
                for (String sug : sugerencias) {
                    System.out.println("- " + sug);
                }
            }
        } else {
            imprimirResultado(resultado);
        }
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
            System.out.println("Error: La columna no está indexada o no es un índice ordenado");
            return;
        }
    
        Indice indice = gestor.obtenerIndice(columna);
        if (!(indice instanceof IndiceOrdenado)) {
            System.out.println("Error: La columna no tiene un índice ordenado");
            return;
        }
    
        System.out.print("Valor inicial del rango: ");
        String valorInicial = scanner.nextLine().trim();
    
        System.out.print("Valor final del rango: ");
        String valorFinal = scanner.nextLine().trim();
    
        BuscadorBinario buscador = new BuscadorBinario((IndiceOrdenado) indice);
        int[] posiciones = buscador.buscarRango(valorInicial, valorFinal);
    
        if (posiciones.length == 0) {
            System.out.println("\nNo se encontraron resultados en el rango especificado.");
        } else {
            System.out.println("\nResultados encontrados (" + posiciones.length + "):");
            for (int pos : posiciones) {
                for (int j = 0; j < gestor.getColumnas(); j++) {
                    System.out.print(gestor.getDato(pos, j) + "\t");
                }
                System.out.println();
            }
        }
    }

    private void compararAlgoritmos() {
        System.out.print("Ingrese el nombre de la columna a ordenar: ");
        String columna = scanner.nextLine();

        String[] valores = gestor.obtenerValoresUnicos(columna);
        if (valores.length == 0) {
            System.out.println("No hay datos para ordenar en esta columna");
            return;
        }

        System.out.println("\n=== COMPARACIÓN DE ALGORITMOS ===");
        System.out.println("Cantidad de elementos a ordenar: " + valores.length);

        probarAlgoritmo("QuickSort", new QuickSort(), valores.clone());

        probarAlgoritmo("MergeSort", new MergeSort(), valores.clone());

        probarAlgoritmo("HeapSort", new HeapSort(), valores.clone());
    }

    private void probarAlgoritmo(String nombre, AlgoritmoOrdenacion algoritmo, String[] valores) {
        System.out.println("\nProbando " + nombre + "...");
        long inicio = System.nanoTime();

        int[][] posiciones = new int[valores.length][1];
        int[] contadores = new int[valores.length];
        for (int i = 0; i < valores.length; i++) {
            posiciones[i][0] = i;
            contadores[i] = 1;
        }

        algoritmo.ordenar(valores, posiciones, contadores, valores.length);

        long fin = System.nanoTime();
        double tiempo = (fin - inicio) / 1_000_000.0;

        System.out.println("Tiempo de ejecución: " + tiempo + " ms");
        System.out.println("Primeros 5 valores ordenados:");
        for (int i = 0; i < 5 && i < valores.length; i++) {
            System.out.println(valores[i]);
        }
    }

    private void probarAlgoritmoEspecifico() {
        System.out.print("Ingrese el nombre de la columna a ordenar: ");
        String columna = scanner.nextLine();

        System.out.println("Algoritmos disponibles: quicksort, mergesort, heapsort");
        System.out.print("Seleccione el algoritmo: ");
        String algoritmoNombre = scanner.nextLine().toLowerCase();

        AlgoritmoOrdenacion algoritmo;
        switch (algoritmoNombre) {
            case "quicksort":
                algoritmo = new QuickSort();
                break;
            case "mergesort":
                algoritmo = new MergeSort();
                break;
            case "heapsort":
                algoritmo = new HeapSort();
                break;
            default:
                System.out.println("Algoritmo no reconocido");
                return;
        }

        String[] valores = gestor.obtenerValoresUnicos(columna);
        if (valores.length == 0) {
            System.out.println("No hay datos para ordenar en esta columna");
            return;
        }

        probarAlgoritmo(algoritmoNombre.substring(0, 1).toUpperCase() + algoritmoNombre.substring(1),
                algoritmo, valores);
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