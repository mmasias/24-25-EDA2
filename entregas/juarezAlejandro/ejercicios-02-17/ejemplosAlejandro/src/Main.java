/*public class Main {
    public static void main(String[] args) {
        Esclavo esclavo1 = new Esclavo();
        esclavo1.trabajar();

        Becario becario1 = new Becario();
        becario1.trabajar();

        Esclavo esclavo2 = new Becario();
        esclavo2.trabajar();

        // Becario becario2 = new Esclavo(); // ❌ Error de compilación
    }
}*/

/* public class Main {
    public static void main(String[] args) {
        Esclavo esclavo3 = new Becario();
        esclavo3.trabajar(); // "Haciendo trabajo gratis con ilusión de ser feliz"
        // esclavo3.pedirContrato(); // ❌ ERROR: El método no está en la clase Esclavo
    }
} */

/* public class Main {
    public static void main(String[] args) {
        Esclavo[] esclavos = new Becario[3];
        esclavos[0] = new Becario();
        // esclavos[1] = new Esclavo(); // ❌ Error en tiempo de ejecución
    }
} */

/* public class Main {
    public static void main(String[] args) {
        Esclavo[] esclavos = new Becario[3];
        esclavos[0] = new Becario(); // Válido
        // esclavos[1] = new Esclavo(); // Error de compilación
    }
} */

/*public class Main {
    public static void main(String[] args) {
        Becario becario1 = new Becario();
        Esclavo esclavo1 = becario1;

        System.out.println(becario1.equals(esclavo1)); // true, porque apuntan al mismo objeto
    }
}*/

/* public class Main {
    public static void main(String[] args) {
        // Esclavo esclavo = new Esclavo(); // ❌ Error: No se puede instanciar una clase abstracta
        Becario becario = new Becario();
        becario.trabajar(); // "Trabajando sin descanso"
        becario.quejarse(); // "¡Necesito un sueldo!"
    }
} */

/* public class Main {
    public static void main(String[] args) {
        Becario becario = new Becario();
        System.out.println(becario.pedirAumento()); // "Jefe, ¿me puede pagar algo?"
    }
} */

public class Main {
    public static void main(String[] args) {
        Esclavo esclavo = new Esclavo();
        esclavo.descansar(30);
        esclavo.descansar("silla");
        esclavo.descansar(2, "sofá");
    }
}
