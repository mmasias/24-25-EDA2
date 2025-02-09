import java.util.Arrays;
import java.util.List;

public class ColorManager {
    private List<String> colors = Arrays.asList("Negro", "Blanco", "Cyan", "Magenta");

    public String mixColors(String color1, String color2) {
        if (colors.contains(color1) && colors.contains(color2)) {
            return "Mezcla de " + color1 + " y " + color2;
        }
        return "Color no soportado";
    }
}
