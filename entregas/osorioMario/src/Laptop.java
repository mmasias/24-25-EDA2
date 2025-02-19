class Laptop extends Computadora implements Configurable {
    @Override
    public void encender() {
        System.out.println("Encendiendo la laptop...");
    }

    public void plegar() {
        System.out.println("Plegando la laptop...");
    }

    @Override
    public void configurar() {
        System.out.println("Configurando la laptop...");
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Laptop;
    }
}
