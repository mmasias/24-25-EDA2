public class Buffer {
    private Frame Frame1 = new Frame();
    private Frame Frame2 = new Frame();
    private int ActiveFrame = 1;

    public void Start() {
        System.out.println("Se inicializa el Buffer");
    }

    public void Stop() {
        System.out.println("Se detiene el Buffer");
    }

    public void SwitchFrame() {
        setActiveFrame((getActiveFrame() == 1) ? 2 : 1);
    }


    public int getActiveFrame() {
        return ActiveFrame;

    }

    public void setActiveFrame(int activeFrame) {
        ActiveFrame = activeFrame;

    }

    public void ToggleFrame() {
        SwitchFrame();
    }
}