public class Lista {
    Nodo[] Nodos = new Nodo[10]; 
    private int count = 0; 

    public void addNodo(Nodo nodo) {
        if (count < Nodos.length) {
            Nodos[count] = nodo;
            count++;
        } else {
            System.out.println("No se puede agregar más nodos.");
        }
    }

    public void removeNodo(Nodo nodo) {
        for (int i = 0; i < count; i++) {
            if (Nodos[i] == nodo) {
                
                for (int j = i; j < count - 1; j++) {
                    Nodos[j] = Nodos[j + 1];
                }
                Nodos[count - 1] = null; 
                count--;
                return;
            }
        }
        System.out.println("Nodo no encontrado.");
    }

    public Nodo getNodo(int index) {
        if (index >= 0 && index < count) {
            return Nodos[index];
        } else {
            System.out.println("Índice fuera de rango.");
            return null;
        }
    }

    public void setNodo(int index, Nodo nodo) {
        if (index >= 0 && index < count) {
            nodos[index] = nodo;
        } else {
            System.out.println("Índice fuera de rango.");
        }
    }

}