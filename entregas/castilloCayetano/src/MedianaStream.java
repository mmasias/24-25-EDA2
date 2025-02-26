public class MedianaStream {
    //Completado
    private Node head;
    private int size;

    public MedianaStream() {
        head = null;
        size = 0;
    }

    public static void main(String[] args) {
        imprimirMedianaStream();
    }
    public void mostrar(){
        imprimirMedianaStream();
    }

    public static void imprimirMedianaStream() {
        MedianaStream medianaStream = new MedianaStream();
        int[] stream = {1, 3, 2, 4, 5};
        for (int num : stream) {
            medianaStream.addNumber(num);
            System.out.println(medianaStream.findMedian());
        }
    }

    public void addNumber(int num) {
        head = insertNode(head, num);
        size++;
    }

    public double findMedian() {
        if (size == 0) {
            throw new IllegalStateException("No hay elementos en el stream");
        }
        Node current = head;
        for (int i = 0; i < (size - 1) / 2; i++) {
            current = current.next;
        }
        if (size % 2 == 0) {
            return (current.value + current.next.value) / 2.0;
        } else {
            return current.value;
        }
    }

    private Node insertNode(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null || value < head.value) {
            newNode.next = head;
            return newNode;
        }
        Node current = head;
        while (current.next != null && current.next.value < value) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    private class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
}