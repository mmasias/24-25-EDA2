public class Superposicion {
    private char[][] colorImagen;

    public Superposicion(int altura, int anchura) {
        colorImagen = new char[altura][anchura];
    }

    public char combinarColores(char color1, char color2) {
        return (color1 != ' ' && color2 != ' ') ? '*' : (color1 != ' ' ? color1 : color2);
    }
}

