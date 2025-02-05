public class Nodo {
    private Buffer buffer = new Buffer();
    private InputManager inputManager = new InputManager();
    private Frame frame = new Frame();

    public void Initialize() {
        System.out.println("Nodo inicializado");
    }

    public void run() {
        System.out.println("Nodo ejecutándose");
    }

    public void UpdatePixel(int x, int y, int color) {
        inputManager.UpdatePixel(x, y, color);
    }

    public void SwitchFrames() {
        buffer.SwitchFrame();
    }
}
