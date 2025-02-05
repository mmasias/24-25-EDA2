public class Pixel {
    private boolean estado;
    private String color;

    public Pixel(boolean estado, String color) {
        this.estado = estado;
        this.color = color;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setState(boolean estado) {
        this.estado = estado;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
