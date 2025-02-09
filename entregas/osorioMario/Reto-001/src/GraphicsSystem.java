import java.util.TimerTask;

public class GraphicsSystem {
    private DoubleBuffer buffer;
    private ColorManager colorManager;
    private PatternManager patternManager;
    private TimerManager timerManager;

    public GraphicsSystem(int width, int height, int interval) {
        buffer = new DoubleBuffer(width, height);
        colorManager = new ColorManager();
        patternManager = new PatternManager();
        timerManager = new TimerManager();
    }

    public void updatePixel(int x, int y, String color) {
        buffer.getCurrentBuffer().updatePixel(x, y, color);
    }

    public void startPatternSwitch(int interval) {
        timerManager.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                patternManager.switchPattern();
                render();
            }
        }, 0, interval);
    }

    public void render() {
        buffer.swapBuffers();
        buffer.getCurrentBuffer().display();
    }
}
