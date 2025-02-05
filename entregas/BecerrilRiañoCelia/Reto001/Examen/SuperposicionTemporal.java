package Examen;
import java.util.HashMap;
import java.util.Map;

class SuperposicionTemporal {
    private Map<Character, Map<Character, Character>> colorTable;

    public SuperposicionTemporal() {
        colorTable = new HashMap<>();

        colorTable.put('.', new HashMap<>());
        colorTable.put('#', new HashMap<>());
        colorTable.put('+', new HashMap<>());
        colorTable.put('-', new HashMap<>());
        colorTable.get('.').put('.', '.'); 
        colorTable.get('#').put('#', '#'); 
        colorTable.get('+').put('+', '+'); 
        colorTable.get('-').put('-', '-'); 
        colorTable.get('.').put('#', '@'); 
        colorTable.get('#').put('.', '@'); 
        colorTable.get('.').put('+', ':'); 
        colorTable.get('+').put('.', ':'); 
        colorTable.get('.').put('-', ';'); 
        colorTable.get('-').put('.', ';'); 
        colorTable.get('#').put('+', '='); 
        colorTable.get('+').put('#', '='); 
        colorTable.get('#').put('-', '&'); 
        colorTable.get('-').put('#', '&'); 
        colorTable.get('+').put('-', '$'); 
        colorTable.get('-').put('+', '$'); 
    }

    public char combineColors(char color1, char color2) {
        return colorTable.containsKey(color1) && colorTable.get(color1).containsKey(color2)
                ? colorTable.get(color1).get(color2)
                : color1; 
    }
}
