// Entrelazado.java
import java.util.HashMap;
import java.util.Map;

public class Entrelazado {

    private Map<Character, Map<Character, Character>> colorTabla;

    public Entrelazado() {
        colorTabla = new HashMap<>();
        agregarCombinacion('R', 'Y', 'O');
        agregarCombinacion('R', 'B', 'P');
        agregarCombinacion('Y', 'B', 'G');

        agregarCombinacion('R', 'R', 'R');
        agregarCombinacion('Y', 'Y', 'Y');
        agregarCombinacion('B', 'B', 'B');
    }

    
    private void agregarCombinacion(char c1, char c2, char resultado) {
        colorTabla.computeIfAbsent(c1, k -> new HashMap<>()).put(c2, resultado);
        colorTabla.computeIfAbsent(c2, k -> new HashMap<>()).put(c1, resultado);
    }

    
    public char combinarColores(char color1, char color2) {
        if (colorTabla.containsKey(color1)) {
            Map<Character, Character> innerMap = colorTabla.get(color1);
            if (innerMap.containsKey(color2)) {
                return innerMap.get(color2);
            }
        }
        return color1;
    }
}
