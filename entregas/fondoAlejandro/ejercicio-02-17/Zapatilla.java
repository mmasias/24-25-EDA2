class Zapatilla extends Producto {
    private String talla;

    public Zapatilla(String nombre, double precio, String talla) {
        super(nombre, precio);
        this.talla = talla;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Zapatilla: " + nombre + ", Precio: $" + precio + ", Talla: " + talla);
    }
}