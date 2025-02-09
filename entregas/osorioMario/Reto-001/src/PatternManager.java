import java.util.LinkedList;
import java.util.Queue;

public class PatternManager {
    private Queue<String[][]> patterns = new LinkedList<>();

    public PatternManager() {
        patterns.offer(new String[][]{{"X", "O"}, {"O", "X"}});
        patterns.offer(new String[][]{{"O", "X"}, {"X", "O"}});
    }

    public void switchPattern() {
        patterns.offer(patterns.poll()); // Mueve el primer patrón al final de la cola
    }

    public String[][] getCurrentPattern() {
        return patterns.peek();
    }
}
