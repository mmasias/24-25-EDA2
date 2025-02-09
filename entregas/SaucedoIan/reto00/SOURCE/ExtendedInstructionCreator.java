import java.util.ArrayList;
import java.util.List;

public class ExtendedInstructionCreator {
  private static final int FRAME_WIDTH = 40;
  private static final int TOTAL_WIDTH = FRAME_WIDTH;

  public List<List<Instruction>> createInstructions(int totalRows, int totalCols, int frames, int refreshRate,
      char[] colors) {
    List<List<Instruction>> allInstructions = new ArrayList<>();
    List<Instruction> instructions = new ArrayList<>();

    for (int y = 0; y < totalRows; y++) {
      for (int x = 0; x < TOTAL_WIDTH; x++) {
        Pixel pixel = new Pixel();

        // House roof (triangle)
        if (y == 2 && x >= 15 && x <= 25) {
          pixel.setAsciiValue("^");
          pixel.setColor("m");
        }
        // House walls
        else if (y >= 3 && y <= 7 && x >= 13 && x <= 27) {
          // Door
          if (y >= 5 && y <= 7 && x >= 18 && x <= 22) {
            pixel.setAsciiValue("|");
            pixel.setColor("b");
          }
          // Windows
          else if (y == 4 && (x == 15 || x == 25)) {
            pixel.setAsciiValue("*");
            pixel.setColor("c");
          }
          // Regular walls
          else {
            pixel.setAsciiValue("#");
            pixel.setColor("n");
          }
        } else {
          pixel.setAsciiValue(" ");
          pixel.setColor("n");
        }

        Instruction instr = new Instruction();
        instr.createInstruction(pixel, x, y);
        instructions.add(instr);
      }
    }

    allInstructions.add(instructions);
    return allInstructions;
  }
}