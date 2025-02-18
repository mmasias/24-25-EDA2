### Herencia

```java
class Esclavo {
    public void trabajar() {
        System.out.println("Trabajando sin descanso");
    }
}

class Becario extends Esclavo {
    @Override
    public void trabajar() {
        System.out.println("Haciendo trabajo gratis con ilusión de ser feliz");
    }
}

public class Main {
    public static void main(String[] args) {
        Esclavo esclavo1 = new Esclavo();
        esclavo1.trabajar(); // "Trabajando sin descanso"

        Becario becario1 = new Becario();
        becario1.trabajar(); // "Haciendo trabajo gratis con ilusión de ser feliz"
    }
}
```

---

---

---

### Polimorfismo

```java
public class Main {
    public static void main(String[] args) {
        Esclavo esclavo2 = new Becario();
        esclavo2.trabajar(); // "Haciendo trabajo gratis con ilusión de ser feliz" (Ejemplo de polimorfismo)
    }
}
```

- Aquí se usa polimorfismo, ya que esclavo2 tiene tipo Esclavo, pero ejecuta la versión sobrescrita de trabajar() en Becario.

---

---

---

### Error de asignación

```java
public class Main {
    public static void main(String[] args) {
        Becario becario2 = new Esclavo(); // ❌ Error de compilación
    }
}
```

- No se puede asignar un Esclavo a una variable de tipo Becario, porque un Esclavo no necesariamente es un Becario.

---

---

---

### Métodos no accesibles por polimorfismo

```java
class Becario extends Esclavo {
    @Override
    public void trabajar() {
        System.out.println("Haciendo trabajo gratis con ilusión de ser feliz");
    }

    public void pedirContrato() {
        System.out.println("Por favor, ¿me pueden pagar?");
    }
}

public class Main {
    public static void main(String[] args) {
        Esclavo esclavo3 = new Becario();
        esclavo3.trabajar(); // "Haciendo trabajo gratis con ilusión de ser felices"
        esclavo3.pedirContrato(); // ❌ ERROR: El método no está en la clase Esclavo
    }
}
```

- pedirContrato() no está en Esclavo, por lo que la referencia de tipo Esclavo no puede acceder a él.

---

---

---

### Array de objetos

```java
public class Main {
    public static void main(String[] args) {
        Esclavo[] esclavos = new Becario[3];
        esclavos[0] = new Becario();
        esclavos[1] = new Esclavo(); // ❌ Error en tiempo de ejecución
    }
}
```

- Se crea un array de Becario[], pero se intenta meter un Esclavo, lo que genera un error en tiempo de ejecución.

---

---

---

### Arrays y polimorfismo

```java
class Esclavo {
    public void trabajar() {
        System.out.println("Trabajando sin descanso");
    }
}

class Becario extends Esclavo {
    @Override
    public void trabajar() {
        System.out.println("Haciendo trabajo gratis con ilusión de ser feliz");
    }
}

public class Main {
    public static void main(String[] args) {
        Esclavo[] esclavos = new Becario[3];
        esclavos[0] = new Becario(); // Válido
        // esclavos[1] = new Esclavo(); // Error de compilación
    }
}
```

- esclavos es un array de tipo Esclavo, pero se inicializa con un array de Becario. Solo puedes almacenar instancias de Becario o sus subclases en este array.

---

---

---

### Comparación de objetos

```java
public class Main {
    public static void main(String[] args) {
        Becario becario1 = new Becario();
        Esclavo esclavo1 = becario1;

        System.out.println(becario1.equals(esclavo1)); // true, porque apuntan al mismo objeto
    }
}
```

- becario1 y esclavo1 apuntan a la misma instancia de Becario, por lo que equals() devolverá true.

---

---

---

### Clases abstractas

```java
abstract class Esclavo {
    public void trabajar() {
        System.out.println("Trabajando sin descanso");
    }

    public abstract void quejarse();
}

class Becario extends Esclavo {
    @Override
    public void quejarse() {
        System.out.println("¡Necesito un sueldo!");
    }
}

public class Main {
    public static void main(String[] args) {
        // Esclavo esclavo = new Esclavo(); // ❌ Error: No se puede instanciar una clase abstracta
        Becario becario = new Becario();
        becario.trabajar(); // "Trabajando sin descanso"
        becario.quejarse(); // "¡Necesito un sueldo!"
    }
}
```

- Esclavo es abstracta, por lo que no se puede instanciar directamente.

---

---

---

### Interfaces

```java
interface MalPagado {
    String pedirAumento();
}

class Becario extends Esclavo implements MalPagado {
    @Override
    public String pedirAumento() {
        return "Jefe, ¿me puede pagar algo?";
    }
}

public class Main {
    public static void main(String[] args) {
        Becario becario = new Becario();
        System.out.println(becario.pedirAumento()); // "Jefe, ¿me puede pagar algo?"
    }
}

```

- MalPagado es una interfaz que Becario debe implementar.

---

---

---

### Sobrecarga incorrecta

```java
class Esclavo {
    public void descansar(int minutos) {}
    public void descansar(String lugar) {}
    public void descansar(int horas) {} // ❌ Error de compilación: Se repite el tipo de parámetro
}
```

- Error: No se puede definir dos métodos con el mismo nombre y el mismo tipo de parámetro (int).

---

---

---

### Sobrecarga correcta

```java
class Esclavo {
    public void descansar(int minutos) {}
    public void descansar(String lugar) {}
    public void descansar(int horas, String lugar) {} // ✅ Correcto, los parámetros son diferentes
}

public class Main {
    public static void main(String[] args) {
        Esclavo esclavo = new Esclavo();
        esclavo.descansar(30);        // Llama al método con minutos
        esclavo.descansar("silla");   // Llama al método con lugar
        esclavo.descansar(2, "sofá"); // Llama al método con horas y lugar
    }
}
```

- Aquí sí funciona, porque los parámetros son distintos.
