import java.util.LinkedList;
import java.util.Queue;

public class BufferFrame {
  private Queue<Frame> bufferFrameQueue = new LinkedList<>();

  public void addFrame(Frame frame) {
    bufferFrameQueue.add(frame);

  }

  public Frame getFrame() {
    return bufferFrameQueue.poll();
  }

  public boolean isEmpty() {
    return bufferFrameQueue.isEmpty();
  }
}
