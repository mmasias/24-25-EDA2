public class Extended {
  private static final int ROWS = 10;
  private static final int COLS = 40;
  private static final int FRAMES = 110;
  private static final int REFRESH = 20;

  public static void main(String[] args) {
    char[] palette = { '.', '#', '+', '*' };

    ExtendedInstructionCreator creator = new ExtendedInstructionCreator();
    var frames = creator.createInstructions(ROWS, COLS, FRAMES, REFRESH, palette);

    // Setup pipeline components
    FrameManager manager = new FrameManager();
    manager.setRefreshRate(REFRESH);

    Renderer display = new Renderer();
    display.setMode(Renderer.RenderMode.EXTENDED);

    // Process each frame
    for (var frame : frames) {
      var buffer = new BufferFrame();
      var engine = new RendererEngine(buffer);
      engine.setMode(RendererEngine.RenderMode.EXTENDED);

      // Add all instructions before processing
      for (var instruction : frame) {
        if (instruction != null) {
          engine.addInstruction(instruction);
        }
      }

      // Process and get frame halves
      engine.processFrame();
      Frame leftHalf = engine.getNextFrame();
      Frame rightHalf = engine.getNextFrame();

      // Render both halves
      if (leftHalf != null && rightHalf != null) {
        clearConsole();
        display.renderFrames(leftHalf, rightHalf);
        sleep(REFRESH);
      }
    }
  }

  private static void clearConsole() {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }

  private static void sleep(int ms) {
    try {
      Thread.sleep(ms);
    } catch (InterruptedException e) {
    }
  }
}