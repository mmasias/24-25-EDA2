class Cliente {
    private String nombre;
    private double saldo;

    public Cliente(String nombre, double saldo) {
        this.nombre = nombre;
        this.saldo = saldo;
    }

    public void comprar(Producto producto) {
        if (saldo >= producto.precio) {
            saldo -= producto.precio;
            System.out.println(nombre + " compró " + producto.nombre + ". Saldo restante: $" + saldo);
        } else {
            System.out.println(nombre + " no tiene suficiente saldo para comprar " + producto.nombre);
        }
    }
}