import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterfazV2 {

    private Map<Integer, String> nombres;
    private Map<Integer, Runnable> acciones;

    public InterfazV2() {
        nombres = new HashMap<>();
        acciones = new HashMap<>();

        nombres.put(1, "ArrayRotado");
        acciones.put(1, () -> new ArrayRotado().mostrar());

        nombres.put(2, "BusquedaPalabra");
        acciones.put(2, () -> new BusquedaPalabra().mostrar());

        nombres.put(3, "CasiOrdenado");
        acciones.put(3, () -> new CasiOrdenado().mostrar());

        nombres.put(4, "CombinacionArrays");
        acciones.put(4, () -> new CombinacionArrays().mostrar());

        nombres.put(5, "ContadorInversiones");
        acciones.put(5, () -> new ContadorInversiones().mostrar());

        nombres.put(6, "ElementoMayoritario");
        acciones.put(6, () -> new ElementoMayoritario().mostrar());

        nombres.put(7, "ElementoUnico");
        acciones.put(7, () -> new ElementoUnico().mostrar());

        nombres.put(8, "KElementosCercanos");
        acciones.put(8, () -> new KElementosCercanos().mostrar());

        nombres.put(9, "MedianaStream");
        acciones.put(9, () -> new MedianaStream().mostrar());

        nombres.put(10, "Montaña");
        acciones.put(10, () -> new Montaña().mostrar());

        nombres.put(11, "NumeroFaltante");
        acciones.put(11, () -> new NumeroFaltante().mostrar());

        nombres.put(12, "ParesDiferencia");
        acciones.put(12, () -> new ParesDiferencia().mostrar());

        nombres.put(13, "Permutaciones");
        acciones.put(13, () -> new Permutaciones().mostrar());

        nombres.put(14, "PicoMontaña");
        acciones.put(14, () -> new PicoMontaña().mostrar());

        nombres.put(15, "ProductoDefectuoso");
        acciones.put(15, () -> new ProductoDefectuoso().mostrar());

        nombres.put(16, "PuntoEquilibrio");
        acciones.put(16, () -> new PuntoEquilibrio().mostrar());

        nombres.put(17, "Subconjuntos");
        acciones.put(17, () -> new Subconjuntos().mostrar());

        nombres.put(18, "Subsecuencia");
        acciones.put(18, () -> new Subsecuencia().mostrar());

        nombres.put(19, "SumaMaxima");
        acciones.put(19, () -> new SumaMaxima().mostrar());

        nombres.put(20, "SumaObjetivo");
        acciones.put(20, () -> new SumaObjetivo().mostrar());

        nombres.put(21, "TriangulosPosibles");
        acciones.put(21, () -> new TriangulosPosibles().mostrar());

        nombres.put(22, "TripletesSumaCero");
        acciones.put(22, () -> new TripletesSumaCero().mostrar());
    }

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Mostrar todo");
            System.out.println("2. Mostrar selección");
            System.out.println("3. Salir");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    mostrarTodo();
                    break;
                case 2:
                    mostrarSeleccion();
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 3);

        scanner.close();
    }

    private void mostrarTodo() {
        System.out.println("Mostrando todo...");
        for (Map.Entry<Integer, Runnable> entry : acciones.entrySet()) {
            System.out.println("Llamando a " + nombres.get(entry.getKey()) + "...");
            entry.getValue().run();
            System.out.println("--------------------");
        }
    }

    private void mostrarSeleccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la clase a mostrar:");
        for (int i = 1; i <= nombres.size(); i++) {
            System.out.println(i + ". " + nombres.get(i));
        }
        int seleccion = scanner.nextInt();

        if (acciones.containsKey(seleccion)) {
            System.out.println("Llamando a " + nombres.get(seleccion) + "...");
            acciones.get(seleccion).run();
        } else {
            System.out.println("Selección no válida.");
        }
    }
}