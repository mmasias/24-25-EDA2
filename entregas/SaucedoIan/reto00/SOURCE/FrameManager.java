import java.util.LinkedList;
import java.util.Queue;

public class FrameManager {
  private Object frame;
  private Queue<Object> bufferFrameQueue = new LinkedList<>();
  public int refreshRate;

  public void Fetch(Object frame) {
    this.frame = frame;

  }

  public void Send(Object frame) {
    bufferFrameQueue.add(frame);

  }

  public void Receive(Object frame) {
    this.frame = frame;

  }

  void setRefreshRate(int REFRESH_RATE) {
    this.refreshRate = REFRESH_RATE;

  }

}
