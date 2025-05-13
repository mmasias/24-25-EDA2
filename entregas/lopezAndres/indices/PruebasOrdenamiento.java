public class PruebasOrdenamiento {
    public static void main(String[] args) {
        probarTiposOrdenamiento();
        probarAlgoritmosOrdenamiento();
        probarBusquedas();
        probarIndices();
        probarBusquedaBinaria();
        System.out.println("Todas las pruebas completadas exitosamente.");
    }

    private static void probarTiposOrdenamiento() {
        GestorCSV gestor = new GestorCSV(10, 4);
        String[] cabeceras = { "ID", "Nombre", "Asignatura", "Calificacion" };
        String[][] datos = {
                { "1001", "Ana García", "Programación 1", "85" },
                { "1002", "Juan López", "Programación 1", "90" },
                { "1003", "María Pérez", "Programación 1", "75" }
        };
        gestor.cargarDatos(cabeceras, datos);

        gestor.crearIndiceOrdenado("Calificacion", false, "quicksort");
        String[] calificaciones = gestor.obtenerValoresUnicos("Calificacion");
        assert calificaciones[0].equals("75") : "Error en ordenamiento numérico ascendente";
        assert calificaciones[2].equals("90") : "Error en ordenamiento numérico ascendente";

        gestor.crearIndiceOrdenado("Nombre", false, "quicksort");
        String[] nombres = gestor.obtenerValoresUnicos("Nombre");
        assert nombres[0].equals("Ana García") : "Error en ordenamiento alfabético ascendente";
        assert nombres[2].equals("María Pérez") : "Error en ordenamiento alfabético ascendente";

        System.out.println("Pruebas de tipos de ordenamiento completadas");
    }

    private static void probarAlgoritmosOrdenamiento() {
        GestorCSV gestor = new GestorCSV(10, 4);
        String[] cabeceras = { "ID", "Valor", "Tipo", "Numero" };
        String[][] datos = {
                { "1", "Z", "A", "9" },
                { "2", "Y", "B", "8" },
                { "3", "X", "C", "7" },
                { "4", "W", "D", "6" },
                { "5", "V", "E", "5" }
        };
        gestor.cargarDatos(cabeceras, datos);

        gestor.crearIndiceOrdenado("Valor", false, "quicksort");
        String[] resultadoQuick = gestor.obtenerValoresUnicos("Valor");
        assert resultadoQuick[0].equals("V") : "Error en QuickSort";

        gestor.crearIndiceOrdenado("Valor", false, "mergesort");
        String[] resultadoMerge = gestor.obtenerValoresUnicos("Valor");
        assert resultadoMerge[0].equals("V") : "Error en MergeSort";

        gestor.crearIndiceOrdenado("Valor", false, "heapsort");
        String[] resultadoHeap = gestor.obtenerValoresUnicos("Valor");
        assert resultadoHeap[0].equals("V") : "Error en HeapSort";

        System.out.println("Pruebas de algoritmos de ordenamiento completadas");
    }

    private static void probarBusquedas() {
        GestorCSV gestor = new GestorCSV(10, 4);
        String[] cabeceras = { "ID", "Nombre", "Curso", "Nota" };
        String[][] datos = {
                { "1", "Ana", "Math", "90" },
                { "2", "Ana", "Physics", "85" },
                { "3", "Pedro", "Math", "95" }
        };
        gestor.cargarDatos(cabeceras, datos);
        gestor.crearIndiceOrdenado("Nombre", false, "quicksort");

        String[][] resultado = gestor.buscarPorIndice("Nombre", "Ana");
        assert resultado.length == 2 : "Error en búsqueda múltiple";
        assert resultado[0][1].equals("Ana") : "Error en resultado de búsqueda";

        System.out.println("Pruebas de búsquedas completadas");
    }

    private static void probarIndices() {
        GestorCSV gestor = new GestorCSV(10, 4);
        String[] cabeceras = { "ID", "Nombre", "Curso", "Nota" };
        String[][] datos = {
                { "1", "Ana", "Math", "90" },
                { "2", "Juan", "Physics", "85" },
                { "3", "Pedro", "Math", "95" }
        };
        gestor.cargarDatos(cabeceras, datos);

        gestor.crearIndice("Curso");
        assert gestor.estaIndexada("Curso") : "Error en creación de índice normal";

        gestor.crearIndiceOrdenado("Nota", true, "quicksort");
        assert gestor.estaIndexada("Nota") : "Error en creación de índice ordenado";

        System.out.println("Pruebas de índices completadas");
    }

    private static void probarBusquedaBinaria() {
        GestorCSV gestor = new GestorCSV(10, 4);
        String[] cabeceras = { "ID", "Nombre", "Curso", "Nota" };
        String[][] datos = {
                { "1", "Ana", "Math", "90" },
                { "2", "Carlos", "Physics", "85" },
                { "3", "Elena", "Math", "95" },
                { "4", "Juan", "Physics", "88" },
                { "5", "María", "Math", "92" }
        };
        gestor.cargarDatos(cabeceras, datos);

        gestor.crearIndiceOrdenado("Nota", false, "quicksort");
        IndiceOrdenado indice = (IndiceOrdenado) gestor.obtenerIndice("Nota");
        BuscadorBinario buscador = new BuscadorBinario(indice);

        int[] resultado = buscador.buscar("90");
        assert resultado.length == 1 : "Error en búsqueda binaria exacta";
        assert resultado[0] == 0 : "Error en posición encontrada";

        int[] resultadoRango = buscador.buscarRango("85", "90");
        assert resultadoRango.length == 3 : "Error en búsqueda binaria por rango";

        System.out.println("Pruebas de búsqueda binaria completadas");
    }
}
