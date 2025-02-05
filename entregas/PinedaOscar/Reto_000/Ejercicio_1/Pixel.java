package entregas.PinedaOscar.Reto_000.Ejercicio_1;
class Pixel {
    private int color;
    
    public Pixel(int color) {
        this.color = color;
    }
    
    public void actualizarPixel(int nuevoColor) {
        this.color = nuevoColor;
    }
    
    public int getColor() {
        return color;
    }
}

