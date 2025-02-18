# **Simulación de Plantas en Java**

Este proyecto modela el crecimiento y floración de diferentes tipos de plantas usando **POO en Java**.

## **Estructura del Proyecto**
 `Floracion.java` → Interfaz para la floración.

 `Planta.java` → Clase base con métodos comunes.

 `Rosa.java` → Subclase con el método `mostrarFragancia()`.

 `RosaMarchita.java` → Subclase de `Rosa` que representa una rosa marchita.

 `Main.java` → Clase principal para ejecutar el programa.



## **Código Fuente**  

### **Floracion.java**  
```java
public interface Floracion {
    void florecer();
}
```

### **Planta.java**  
```java
public class Planta implements Floracion {

    public void crecer() {
        System.out.println("La planta crece");
    }

    @Override
    public void florecer() {
        System.out.println("La planta florece");
    }

    public void regar() {
        System.out.println("Regando");
    }

    public void regar(String cantidad) {
        System.out.println("Regando con " + cantidad);
    }
}
```

### **Rosa.java**  
```java
public class Rosa extends Planta {

    @Override
    public void crecer() {
        System.out.println("La rosa crece");
    }

    public void mostrarFragancia() {
        System.out.println("La rosa huele bien");
    }
}
```

### **RosaMarchita.java**  
```java
public class RosaMarchita extends Rosa {

    @Override
    public void mostrarFragancia() {
        System.out.println("La rosa huele poco");
    }
}
```

### **Main.java**  
```java
public class Main {

    public static void main(String[] args) {

        Planta planta1 = new Planta();
        planta1.crecer();

        Planta rosa1 = new Rosa();
        rosa1.crecer();

        planta1.regar();
        planta1.regar("500ml");

        if (rosa1 instanceof Rosa) {
            Rosa rosa = (Rosa) rosa1;
            rosa.mostrarFragancia();
        }

        Planta[] plantas = new Rosa[5];
        plantas[0] = new Rosa();
        plantas[1] = (Rosa) rosa1;
        plantas[2] = new Rosa();

        Rosa rosa3 = new Rosa();
        Planta planta2 = rosa3;
        System.out.println(rosa3.equals(planta2));

        new RosaMarchita().mostrarFragancia();

        new Rosa().florecer();
    }
}




