package entregas.castilloCayetano.reto001.src;

class Pixel {
    private char color;

    public Pixel(char color) {
        this.color = color;
    }

    public char getColor() {
        return color;
    }

    public void setColor(char color) {
        this.color = color;
    }

    public static char blendColors(char color1, char color2) {
        if (color1 == '.' && color2 == '.')
            return '.';
        if (color1 == '#' && color2 == '#')
            return '#';
        if (color1 == '+' && color2 == '+')
            return '+';
        if (color1 == '*' && color2 == '*')
            return '*';

        if ((color1 == '#' && color2 == '.') || (color1 == '.' && color2 == '#'))
            return '@';
        if ((color1 == '+' && color2 == '.') || (color1 == '.' && color2 == '+'))
            return ':';
        if ((color1 == '*' && color2 == '.') || (color1 == '.' && color2 == '*'))
            return ';';
        if ((color1 == '#' && color2 == '+') || (color1 == '+' && color2 == '#'))
            return '=';
        if ((color1 == '#' && color2 == '*') || (color1 == '*' && color2 == '#'))
            return '&';
        if ((color1 == '+' && color2 == '*') || (color1 == '*' && color2 == '+'))
            return '$';

        return color1;
    }
}
