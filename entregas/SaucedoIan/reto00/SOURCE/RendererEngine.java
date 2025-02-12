import java.util.LinkedList;
import java.util.List;

public class RendererEngine {
  private static final int FRAME_WIDTH = 20;
  private List<Instruction> instructions;
  private BufferFrame buffer;
  private RenderMode mode;

  public enum RenderMode {
    COLOR,
    EXTENDED
  }

  public RendererEngine(BufferFrame buffer) {
    this.buffer = buffer;
    this.instructions = new LinkedList<>();
    this.mode = RenderMode.COLOR;
  }

  public void processFrame() {
    if (instructions.isEmpty())
      return;

    if (mode == RenderMode.COLOR) {
      processColorMode();
    } else {
      processExtendedMode();
    }
    instructions.clear();
  }

  private void processColorMode() {
    Frame frame = new Frame();
    for (Instruction instr : instructions) {
      int x = instr.getPosX();
      int y = instr.getPosY();
      char pixel = instr.getPixelChar();

      if (x < FRAME_WIDTH) {
        frame.updatePixel(x, y, pixel);
      }
    }
    buffer.addFrame(frame);
  }

  private void processExtendedMode() {
    Frame leftFrame = new Frame();
    Frame rightFrame = new Frame();

    for (Instruction instr : instructions) {
      int x = instr.getPosX();
      int y = instr.getPosY();
      char pixel = instr.getPixelChar();

      if (x < FRAME_WIDTH) {
        leftFrame.updatePixel(x, y, pixel);
        if (pixel != ' ') {
          rightFrame.updatePixel(FRAME_WIDTH - x - 1, y, pixel);
        }
      }
    }
    buffer.addFrame(leftFrame);
    buffer.addFrame(rightFrame);
  }

  public void addInstruction(Instruction instruction) {
    if (instruction != null) {
      instructions.add(instruction);
    }
  }

  public Frame getNextFrame() {
    return buffer.getFrame();
  }

  public void setMode(RenderMode mode) {
    this.mode = mode;
  }

  public boolean hasFrames() {
    return !buffer.isEmpty();
  }
}