import java.util.Scanner;

public class Interfaz {

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

        System.out.println("Llamando a ArrayRotado...");
        ArrayRotado arrayRotado = new ArrayRotado();
        arrayRotado.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a BusquedaPalabra...");
        BusquedaPalabra busquedaPalabra = new BusquedaPalabra();
        busquedaPalabra.mostrar();
        System.out.println(" ");
        System.out.println("--------------------");

        System.out.println("Llamando a CasiOrdenado...");
        CasiOrdenado casiOrdenado = new CasiOrdenado();
        casiOrdenado.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a CombinacionArrays...");
        CombinacionArrays combinacionArrays = new CombinacionArrays();
        combinacionArrays.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a ContadorInversiones...");
        ContadorInversiones contadorInversiones = new ContadorInversiones();
        contadorInversiones.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a ElementoMayoritario...");
        ElementoMayoritario elementoMayoritario = new ElementoMayoritario();
        elementoMayoritario.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a ElementoUnico...");
        ElementoUnico elementoUnico = new ElementoUnico();
        elementoUnico.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a KElementosCercanos...");
        KElementosCercanos kElementosCercanos = new KElementosCercanos();
        kElementosCercanos.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a MedianaStream...");
        MedianaStream medianaStream = new MedianaStream();
        medianaStream.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a Montaña...");
        Montaña montaña = new Montaña();
        montaña.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a NumeroFaltante...");
        NumeroFaltante numeroFaltante = new NumeroFaltante();
        numeroFaltante.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a ParesDiferencia...");
        ParesDiferencia paresDiferencia = new ParesDiferencia();
        paresDiferencia.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a Permutaciones...");
        Permutaciones permutaciones = new Permutaciones();
        permutaciones.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a PicoMontaña...");
        PicoMontaña picoMontaña = new PicoMontaña();
        picoMontaña.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a ProductoDefectuoso...");
        ProductoDefectuoso productoDefectuoso = new ProductoDefectuoso();
        productoDefectuoso.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a PuntoEquilibrio...");
        PuntoEquilibrio puntoEquilibrio = new PuntoEquilibrio();
        puntoEquilibrio.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a Subconjuntos...");
        Subconjuntos subconjuntos = new Subconjuntos();
        subconjuntos.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a Subsecuencia...");
        Subsecuencia subsecuencia = new Subsecuencia();
        subsecuencia.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a SumaMaxima...");
        SumaMaxima sumaMaxima = new SumaMaxima();
        sumaMaxima.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a SumaObjetivo...");
        SumaObjetivo sumaObjetivo = new SumaObjetivo();
        sumaObjetivo.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a TriangulosPosibles...");
        TriangulosPosibles triangulosPosibles = new TriangulosPosibles();
        triangulosPosibles.mostrar();
        System.out.println("--------------------");

        System.out.println("Llamando a TripletesSumaCero...");
        TripletesSumaCero tripletesSumaCero = new TripletesSumaCero();
        tripletesSumaCero.mostrar();
        System.out.println("--------------------");
    }

    private void mostrarSeleccion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la clase a mostrar:");
        System.out.println("1. ArrayRotado");
        System.out.println("2. BusquedaPalabra");
        System.out.println("3. CasiOrdenado");
        System.out.println("4. CombinacionArrays");
        System.out.println("5. ContadorInversiones");
        System.out.println("6. ElementoMayoritario");
        System.out.println("7. ElementoUnico");
        System.out.println("8. KElementosCercanos");
        System.out.println("9. MedianaStream");
        System.out.println("10. Montaña");
        System.out.println("11. NumeroFaltante");
        System.out.println("12. ParesDiferencia");
        System.out.println("13. Permutaciones");
        System.out.println("14. PicoMontaña");
        System.out.println("15. ProductoDefectuoso");
        System.out.println("16. PuntoEquilibrio");
        System.out.println("17. Subconjuntos");
        System.out.println("18. Subsecuencia");
        System.out.println("19. SumaMaxima");
        System.out.println("20. SumaObjetivo");
        System.out.println("21. TriangulosPosibles");
        System.out.println("22. TripletesSumaCero");
        int seleccion = scanner.nextInt();

        switch (seleccion) {
            case 1:
                System.out.println("Llamando a ArrayRotado...");
                ArrayRotado arrayRotado = new ArrayRotado();
                arrayRotado.mostrar();
                break;
            case 2:
                System.out.println("Llamando a BusquedaPalabra...");
                BusquedaPalabra busquedaPalabra = new BusquedaPalabra();
                busquedaPalabra.mostrar();
                break;
            case 3:
                System.out.println("Llamando a CasiOrdenado...");
                CasiOrdenado casiOrdenado = new CasiOrdenado();
                casiOrdenado.mostrar();
                break;
            case 4:
                System.out.println("Llamando a CombinacionArrays...");
                CombinacionArrays combinacionArrays = new CombinacionArrays();
                combinacionArrays.mostrar();
                break;
            case 5:
                System.out.println("Llamando a ContadorInversiones...");
                ContadorInversiones contadorInversiones = new ContadorInversiones();
                contadorInversiones.mostrar();
                break;
            case 6:
                System.out.println("Llamando a ElementoMayoritario...");
                ElementoMayoritario elementoMayoritario = new ElementoMayoritario();
                elementoMayoritario.mostrar();
                break;
            case 7:
                System.out.println("Llamando a ElementoUnico...");
                ElementoUnico elementoUnico = new ElementoUnico();
                elementoUnico.mostrar();
                break;
            case 8:
                System.out.println("Llamando a KElementosCercanos...");
                KElementosCercanos kElementosCercanos = new KElementosCercanos();
                kElementosCercanos.mostrar();
                break;
            case 9:
                System.out.println("Llamando a MedianaStream...");
                MedianaStream medianaStream = new MedianaStream();
                medianaStream.mostrar();
                break;
            case 10:
                System.out.println("Llamando a Montaña...");
                Montaña montaña = new Montaña();
                montaña.mostrar();
                break;
            case 11:
                System.out.println("Llamando a NumeroFaltante...");
                NumeroFaltante numeroFaltante = new NumeroFaltante();
                numeroFaltante.mostrar();
                break;
            case 12:
                System.out.println("Llamando a ParesDiferencia...");
                ParesDiferencia paresDiferencia = new ParesDiferencia();
                paresDiferencia.mostrar();
                break;
            case 13:
                System.out.println("Llamando a Permutaciones...");
                Permutaciones permutaciones = new Permutaciones();
                permutaciones.mostrar();
                break;
            case 14:
                System.out.println("Llamando a PicoMontaña...");
                PicoMontaña picoMontaña = new PicoMontaña();
                picoMontaña.mostrar();
                break;
            case 15:
                System.out.println("Llamando a ProductoDefectuoso...");
                ProductoDefectuoso productoDefectuoso = new ProductoDefectuoso();
                productoDefectuoso.mostrar();
                break;
            case 16:
                System.out.println("Llamando a PuntoEquilibrio...");
                PuntoEquilibrio puntoEquilibrio = new PuntoEquilibrio();
                puntoEquilibrio.mostrar();
                break;
            case 17:
                System.out.println("Llamando a Subconjuntos...");
                Subconjuntos subconjuntos = new Subconjuntos();
                subconjuntos.mostrar();
                break;
            case 18:
                System.out.println("Llamando a Subsecuencia...");
                Subsecuencia subsecuencia = new Subsecuencia();
                subsecuencia.mostrar();
                break;
            case 19:
                System.out.println("Llamando a SumaMaxima...");
                SumaMaxima sumaMaxima = new SumaMaxima();
                sumaMaxima.mostrar();
                break;
            case 20:
                System.out.println("Llamando a SumaObjetivo...");
                SumaObjetivo sumaObjetivo = new SumaObjetivo();
                sumaObjetivo.mostrar();
                break;
            case 21:
                System.out.println("Llamando a TriangulosPosibles...");
                TriangulosPosibles triangulosPosibles = new TriangulosPosibles();
                triangulosPosibles.mostrar();
                break;
            case 22:
                System.out.println("Llamando a TripletesSumaCero...");
                TripletesSumaCero tripletesSumaCero = new TripletesSumaCero();
                tripletesSumaCero.mostrar();
                break;
            default:
                System.out.println("Selección no válida.");
        }
    }
}