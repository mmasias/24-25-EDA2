import java.util.List;
import java.util.ArrayList;

class Lista {
    private List<Node> nodes = new ArrayList<>();

    public void addNode(Node node) {
        nodes.add(node);
    }

    public void removeNode(Node node) {
        nodes.remove(node);
    }

    public Node getNode(int index) {
        return nodes.get(index);
    }

    public void runAll() {
        for (Node node : nodes) {
            node.run();
        }
    }
}
