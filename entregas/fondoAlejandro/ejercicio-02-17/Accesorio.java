class Accesorio extends Producto {
    private String tipo;

    public Accesorio(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public void mostrarInfo() {
        System.out.println("Accesorio: " + nombre + ", Precio: $" + precio + ", Tipo: " + tipo);
    }
}