
public class Color {
    private char[] representacion;
    
    public Color() {

    }
    public char devolverRepresentacion() {
    
    return representacion != null && representacion.length > 0 ? representacion[0] : 0;
    }
}