public class Color {
  private static final int ROWS = 10;
  private static final int COLS = 40;
  private static final int FRAMES = 110;
  private static final int REFRESH = 20;

  public static void main(String[] args) {
    char[] palette = new char[] {
        '.', // NEGRO
        '#', // BLANCO
        '+', // CYAN
        '*' // MAGENTA
    };

    InstructionCreator creator = new InstructionCreator();
    var frames = creator.createInstructions(ROWS, COLS, FRAMES, REFRESH, palette);

    FrameManager manager = new FrameManager();
    manager.setRefreshRate(REFRESH);

    Renderer display = new Renderer();
    display.setMode(Renderer.RenderMode.EXTENDED);

    for (var frame : frames) {
      var buffer = new BufferFrame();
      var engine = new RendererEngine(buffer);
      engine.setMode(RendererEngine.RenderMode.EXTENDED);

      for (var instruction : frame) {
        if (instruction != null) {
          engine.addInstruction(instruction);
        }
      }
      engine.processFrame();

      Frame left = engine.getNextFrame();

      if (left != null) {
        System.out.print("\033[H\033[2J");
        System.out.flush();
        display.renderFrames(left);
        try {
          Thread.sleep(REFRESH);
        } catch (InterruptedException e) {
        }
      }
    }
  }
}