public class Render {
    private Lista lista = new Lista();
    
    public void mostrarLista() {
        for (Node node : Lista.getNodes()) {
            System.out.println(node);
        }
    }
}
