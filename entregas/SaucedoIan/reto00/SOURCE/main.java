import java.util.List;

public class main {
  public static void main(String[] args) throws InterruptedException {
    int totalRows = 10;
    int totalCols = 40;
    int frames = 110;
    int refreshRate = 20;
    char[] colors = { Pixel.NEGRO, Pixel.BLANCO, Pixel.CYAN, Pixel.MAGENTA };

    InstructionCreator instructionCreator = new InstructionCreator();
    List<List<Instruction>> allInstructions = instructionCreator.createInstructions(totalRows, totalCols, frames,
        refreshRate, colors);

    FrameManager frameManager = new FrameManager();
    frameManager.refreshRate = refreshRate;

    Renderer renderer = new Renderer();

    for (List<Instruction> instructions : allInstructions) {
      RendererEngine engine = new RendererEngine(new BufferFrame());
      engine.setMode("extended");

      for (Instruction instr : instructions) {
        engine.ReceiveInstruction(instr);
      }

      engine.DrawFrame();
      Frame bufferedFrame = engine.SendFrame();
      if (bufferedFrame != null) {
        frameManager.Send(bufferedFrame);
        clearScreen();
        renderer.Show(bufferedFrame);
      }

      Thread.sleep(frameManager.refreshRate);
    }
  }

  public static void clearScreen() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
