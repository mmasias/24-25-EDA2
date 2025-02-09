package entregas.reyPablo.codigoPropuesto;

    public enum Pixel {
        NEGRO(0, '.'), BLANCO(1, '#'), CYAN(2, '+'), MAGENTA(3, '*');
    
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
