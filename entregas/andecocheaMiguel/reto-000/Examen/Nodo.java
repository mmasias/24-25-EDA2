public class Nodo {
    
    private Buffer buffer = new Buffer();
    private Manager Manager = new Manager();


    public void UpdatePixel(int x, int y, int color) {
        Manager.UpdatePixel(x, y, color);
    }

    public void SwitchFrames() {
        buffer.SwitchFrame();
    }

    public void Initialize() {
        System.out.println("Nodo inicializado");
    }
}