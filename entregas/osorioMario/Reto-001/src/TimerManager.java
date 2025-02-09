import java.util.Timer;
import java.util.TimerTask;

public class TimerManager {
    private Timer timer;

    public TimerManager() {
        timer = new Timer();
    }

    public void scheduleAtFixedRate(TimerTask task, int delay, int period) {
        timer.scheduleAtFixedRate(task, delay, period);
    }
}
