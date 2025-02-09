class Demo {
    public static void main(String[] args) {
        Buffer buffer = new Buffer(8, 3);
        Manager manager = new Manager(buffer);
        Node node = new Node(manager);
        Renderer renderer = new Renderer(buffer);

        node.actualizarPixel(7, 2, 2);
        node.actualizarPixel(6, 1, 2);
        node.actualizarPixel(5, 0, 2);

        renderer.renderizar();
    }
}