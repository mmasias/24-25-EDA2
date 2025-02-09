
import java.util.LinkedList;

public class RendererEngine {
  private Object frame;
  private String mode;
  private LinkedList<Instruction> instructionsList = new LinkedList<>();
  private BufferFrame bufferFrame;

  public RendererEngine(BufferFrame bufferFrame) {
    this.bufferFrame = bufferFrame;
  }

  public void Node(Object frame) {
    this.frame = frame;
  }

  public void DrawFrame() {
    if (mode == "extended" && !instructionsList.isEmpty()) {
      Frame frameObj = new Frame();

      for (Instruction instr : instructionsList) {
        int frameNumber = instr.SizeExtension ? 2 : 1;
        frameObj.updatePixel(frameNumber, instr.posX, instr.posY, instr.pixelChar);
      }

      bufferFrame.addFrame(frameObj);

    } else {
      System.out.println("Error: RendererEngine mode or instructions not set");
    }
  }

  public Frame SendFrame() {
    if (!bufferFrame.isEmpty()) {
      return bufferFrame.getFrame();
    } else {
      System.out.println("No frame in buffer to send.");
      return null;
    }
  }

  public void SelectRenderMode() {
    if (mode != null) {
      System.out.println("Render mode selected: " + mode);
    } else {
      System.out.println("No render mode set.");
    }
  }

  public void ReceiveInstruction(Object instruction) {
    if (instruction instanceof Instruction) {
      instructionsList.add((Instruction) instruction);
    }
  }

  public void setMode(String mode) {
    this.mode = mode;
  }
}