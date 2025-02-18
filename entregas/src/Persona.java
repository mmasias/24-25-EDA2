public class Persona {
    private String nombre;
    private double pesoKg;
    private int alturaCm;
    private int edad;
    private char genero;

    public Persona() {
        this("Oscar", 18, 80, 180, 'M');
    }

    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }

    public Persona(String nombre, int edad, double pesoKg, int alturaCm, char genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoKg = pesoKg;
        this.alturaCm = alturaCm;
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public int getAlturaCm() {
        return alturaCm;
    }

    public void setAlturaCm(int alturaCm) {
        this.alturaCm = alturaCm;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    @Override
    public String toString() {
        return String.format("Nombre: %s, Edad: %d, Peso: %.2f, Altura: %d, Genero: %c",
                nombre, edad, pesoKg, alturaCm, genero);
    }
}
