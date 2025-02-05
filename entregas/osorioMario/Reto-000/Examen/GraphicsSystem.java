import java.util.Timer;
import java.util.TimerTask;

public class GraphicsSystem {
    private DoubleBuffer buffer;
    private ColorManager colorManager;
    private PatternManager patternManager;
    private Timer timer;

    public GraphicsSystem(int width, int height, int interval) {
        buffer = new DoubleBuffer(width, height);
        colorManager = new ColorManager();
        patternManager = new PatternManager();
        timer = new Timer();

        startPatternSwitch(interval);
    }

    public void updatePixel(int x, int y, String color) {
        buffer.getCurrentBuffer().updatePixel(x, y, color);
    }

    public void startPatternSwitch(int interval) {
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                patternManager.switchPattern();
                buffer.swapBuffers();
                buffer.getCurrentBuffer().fill(patternManager.getCurrentPattern()[0][0]);
                render();
            }
        }, 0, interval);
    }

    public void render() {
        System.out.println("Mostrando Frame Actual:");
        buffer.getCurrentBuffer().display();
    }
}
