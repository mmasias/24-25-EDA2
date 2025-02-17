public abstract class Instrumento implements IMusical {
  protected String nombre;
  protected String tipo;
  protected double precio;

  public Instrumento(String nombre, String tipo, double precio) {
    this.nombre = nombre;
    this.tipo = tipo;
    this.precio = precio;
  }

  public void mostrarInfo() {
    System.out.println("=== Instrumento ===");
    System.out.println("Nombre: " + nombre);
    System.out.println("Tipo: " + tipo);
    System.out.println("Precio: $" + precio);
  }
}