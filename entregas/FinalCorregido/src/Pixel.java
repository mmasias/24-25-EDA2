public enum Pixel {
    NEGRO(0, '.'), 
    BLANCO(1, '#'), 
    CYAN(2, '+'), 
    MAGENTA(3, '*'), 
    GRIS(4,'@'),
    CYAN_TENUE(5,':'), 
    MAGENTA_TENUE(6,';'),
    CYAN_BRILLANTE(7,'='),
    MAGENTA_BRILLANTE(8,'&'),
    BLANCO_TENUE(9,'$');

    private final int color;
    private char caracter;

    Pixel (int color, char caracter) {
        this.color = color;
        this.caracter = caracter;
    }

    public int getColor() {
        return color;
    }

    public char getCaracter() {
        return caracter;
    }
   
}