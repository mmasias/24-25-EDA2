package entregas.Reyes_David.Reto001.Ejercicio_2;

import java.util.HashMap;
import java.util.Map;

public class Pixel {
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

    public static char combinarColores(char color1, char color2) {
        switch ("" + color1 + color2) {
            case "..": return '.';
            case ".#": return '@';
            case ".+": return ':';
            case ".*": return ';';
            case "#.": return '@';
            case "##": return '#';
            case "#+": return '=';
            case "#*": return '&';
            case "+.": return ':';
            case "+#": return '=';
            case "++": return '+';
            case "+*": return '$';
            case "*.": return ';';
            case "*#": return '&';
            case "*+": return '$';
            case "**": return '*';
            default: return '?'; 
        }
    }
}

