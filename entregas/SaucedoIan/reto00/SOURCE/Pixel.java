public class Pixel {
  public String AsciiArray;
  public String color;

  public static final char NEGRO = '.';
  public static final char BLANCO = '#';
  public static final char CYAN = '+';
  public static final char MAGENTA = '*';

  public String GetPixel() {
    if (AsciiArray != null && !AsciiArray.isEmpty()) {
      return AsciiArray;
    } else if (color != null) {
      switch (color.toLowerCase()) {
        case "n":
          return String.valueOf(NEGRO);
        case "b":
          return String.valueOf(BLANCO);
        case "c":
          return String.valueOf(CYAN);
        case "m":
          return String.valueOf(MAGENTA);
        default:
          return " ";
      }
    }
    return " ";
  }

  public String GetColor() { 
    return color;
  }
}
