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

  private String asciiValue;
  private Color pixelColor;

  public Pixel() {
    this.pixelColor = Color.EMPTY;
    this.asciiValue = " ";
  }

  public void setAsciiValue(String value) {
    this.asciiValue = value != null ? value : " ";
  }

  public void setColor(String colorCode) {
    if (colorCode != null) {
      for (Color c : Color.values()) {
        if (c.getCode().equals(colorCode.toLowerCase())) {
          this.pixelColor = c;
          return;
        }
      }
    }
    this.pixelColor = Color.EMPTY;
  }

  public String getPixelValue() {
    if (asciiValue != null && !asciiValue.isEmpty()) {
      return asciiValue;
    }
    return String.valueOf(pixelColor.getSymbol());
  }

  public String getColorCode() {
    return pixelColor.getCode();
  }
}