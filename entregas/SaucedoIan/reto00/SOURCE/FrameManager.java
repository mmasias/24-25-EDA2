import java.util.Queue;
import java.util.LinkedList;

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

}
