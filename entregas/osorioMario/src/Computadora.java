class Computadora {
    public void encender() {
        System.out.println("Encendiendo la computadora...");
    }

    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }
}
