public class Buffer {
    private Frame Frame1 = new Frame();
    private Frame Frame2 = new Frame();
    private int ActiveFrame = 1;
    private int Interval = 100;

    public void SwitchFrame() {
        setActiveFrame((getActiveFrame() == 1) ? 2 : 1);
    }

    public Frame getFrame2() {
        return Frame2;

    }

    public void setFrame2(Frame frame2) {
        Frame2 = frame2;

    }

    public Frame getFrame1() {
        return Frame1;

    }

    public void setFrame1(Frame frame1) {
        Frame1 = frame1;

    }

    public int getActiveFrame() {
        return ActiveFrame;

    }

    public void setActiveFrame(int activeFrame) {
        ActiveFrame = activeFrame;

    }

    public void CombineFrames() {

        System.out.println("Frames combinados");
    }

    public void Start() {
        System.out.println("Buffer iniciado");
    }

    public void Stop() {
        System.out.println("Buffer detenido");
    }

    public void ToggleFrame() {
        SwitchFrame();
    }
}
