import java.util.HashMap;
import java.util.Map;

public class Pixel {
  public enum Color {
    NEGRO('.', "n"),
    BLANCO('#', "b"),
    CYAN('+', "c"),
    MAGENTA('*', "m"),
    EMPTY(' ', "");

    private final char symbol;
    private final String code;

    Color(char symbol, String code) {
      this.symbol = symbol;
      this.code = code;
    }

    public char getSymbol() {
      return symbol;
    }

    public String getCode() {
      return code;
    }
  }

  private static final Map<String, Color> colorMap = new HashMap<>();

  static {
    for (Color color : Color.values()) {
      colorMap.put(color.getCode(), color);
    }
  }

  private String asciiValue;
  private Color pixelColor;

  public Pixel() {
    this.pixelColor = Color.EMPTY;
    this.asciiValue = " ";
  }

  public void setAsciiValue(String value) {
    this.asciiValue = (value != null && !value.isEmpty()) ? value : " ";
  }

  public void setColor(String colorCode) {
    if (colorCode != null) {
      this.pixelColor = colorMap.getOrDefault(colorCode.toLowerCase(), Color.EMPTY);
    } else {
      this.pixelColor = Color.EMPTY;
    }
  }

  public String getPixelValue() {
    return (asciiValue != null && !asciiValue.isEmpty()) ? asciiValue : String.valueOf(pixelColor.getSymbol());
  }

  public String getColorCode() {
    return pixelColor.getCode();
  }
}