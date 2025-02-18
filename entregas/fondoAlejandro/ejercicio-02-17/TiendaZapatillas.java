public class TiendaZapatillas {
    public static void main(String[] args) {
        Zapatilla nike = new Zapatilla("Nike Air", 120.00, "42");
        Accesorio calcetines = new Accesorio("Calcetines deportivos", 10.00, "Ropa");

        Cliente cliente1 = new Cliente("Carlos", 150.00);

        Empleado empleado1 = new Empleado("Laura", "Cajera");

        nike.mostrarInfo();
        calcetines.mostrarInfo();

        cliente1.comprar(nike);
        cliente1.comprar(calcetines);

        empleado1.trabajar();
    }
}
