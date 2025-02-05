class Node {
    private Manager manager;
    
    public Node(Manager manager) {
        this.manager = manager;
    }

    public void actualizarPixel(int x, int y, int color) {
        manager.establecerPixel(x, y, color);
    }
}