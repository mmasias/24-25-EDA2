public class Instruction {
  public char Color;
  public boolean SizeExtension; 
  public int posX, posY; 
  public char pixelChar; 

  public boolean hasColor() {
    return Color != 0; 
  }


  public void createInstruction(Pixel p, int x, int y, boolean isExtended) { 
    String ascii = p.GetPixel();
    char c = (ascii != null && !ascii.isEmpty()) ? ascii.charAt(0) : ' ';
    this.pixelChar = c;
    this.posX = x;
    this.posY = y;
    this.SizeExtension = isExtended;
  }

  public void SendInstruction() {
  
  }
}
