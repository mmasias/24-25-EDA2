### Creación de instancias

```java
public class Animal {
    public void hacerSonido() {
        System.out.println("???");
    }
}

Animal animal1 = new Animal();
```

- Aquí defines una clase llamada Animal con un método hacerSonido() que imprime "???". Luego, creas una instancia de Animal llamada animal1.

---

---

---

### Herencia y sobreescritura de métodos

```java
class Gato extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }
}

Gato gato1 = new Gato(); // Guarda referencia a instancia de objeto de clase Gato en gato1
```

- Explicación: La clase Gato hereda de Animal y sobrescribe el método hacerSonido() para imprimir "Miau". Luego, creas una instancia de Gato llamada gato1.

---

---

---

### Polimorfismo

```java
Animal animal2 = new Gato();
animal2.hacerSonido(); //Imprime "Miau"
```

- Aquí usas polimorfismo. animal2 es una referencia de tipo Animal, pero apunta a una instancia de Gato. Cuando llamas a hacerSonido(), se ejecuta la versión sobrescrita en Gato, imprimiendo "Miau".

---

---

---

### Errores de asignación

```java
Gato gato2 = new Animal(); // Error de compilación
```

- Explicación: Esto es incorrecto porque Gato es una subclase de Animal, y no puedes asignar una instancia de la clase base (Animal) a una referencia de la subclase (Gato). Esto dará un error de compilación.

### Métodos adicionales en la subclase

```java
class Gato extends Animal{
    @Override
    public void hacerSonido(){
        System.out.println("Miau");
    }
    public void ronronear(){
        System.out.println("Prrrrrrr");
    }
}

Animal animal3 = new Gato();
animal3.hacerSonido(); // Imprime "Miau"
animal3.ronronear(); // Error de compilación
```

- Explicación: animal3 es de tipo Animal, por lo que solo puede acceder a métodos definidos en Animal. El método ronronear() no está en Animal, por lo que dará un error de compilación.

---

---

---

### Ejemplo de arrays de objetos

```java
Animal[] animales; // Una variable que va a guardar una referencia de un array de tipo Animal
```

- Se declara un array de Animal, pero aún no se inicializa.

---

---

---

### Arrays y polimorfismo

```java
Animal[] animales = new Gato[3];
animales[0] = new Gato(); // Válido
animales[1] = new Animal(); // Error de compilación
```

- Explicación: animales es un array de tipo Animal, pero se inicializa con un array de Gato. Solo puedes almacenar instancias de Gato o sus subclases en este array. Intentar almacenar una instancia de Animal dará un error.

---

---

---

### Comparación de objetos

```java
Gato gato1 = new Gato();
Animal animal1 = gato1;
System.out.println(gato1.equals(animal1)); // true
```

- Explicación: Aquí gato1 y animal1 apuntan al mismo objeto. El método equals() compara referencias, por lo que devuelve true.

---

---

---

### Clases abstractas

- Una clase abstracta es una clase que no puede ser instanciada directamente. Se usa como base para otras clases y puede contener métodos abstractos (sin implementación) o métodos concretos (con implementación).

---

---

---

### Interfaces

```java
interface Sonoro{
    String hacerSonido();
}

class Gato extends Animal implements Sonoro{
    // Implementación de hacerSonido()
}
```

- Explicación: Una interfaz es una colección de métodos abstractos. La clase Gato implementa la interfaz Sonoro, lo que significa que debe proporcionar una implementación para el método hacerSonido().

---

---

---

### Sobrecarga de métodos (mal ejemplo) (overloading)

```java
class Animal{
    public void saltar(int distancia){}
    public void saltar(Mueble mueble){}
    public void saltar(int altura){} // Error de compilación
}
```

---

---

---

- Explicación: La sobrecarga de métodos permite definir múltiples métodos con el mismo nombre pero con diferentes parámetros. En este caso, los dos primeros métodos están bien, pero el tercero da error porque tiene la misma firma (int) que el primero.

---

---

---

### Sobrecarga de métodos (buen ejemplo)

```java
class Animal{
    public void saltar(int distancia){}
    public void saltar(Mueble mueble){}
    public void saltar(int alto, int distancia){}
}

Animal animal = new Animal();
Mueble sofa = new Mueble();
animal.saltar(sofa); // Llama al segundo método
```

- Explicación: Aquí la sobrecarga está bien definida. Cada método tiene una firma única, por lo que no hay conflictos. Cuando llamas a animal.saltar(sofa), se ejecuta el método que acepta un objeto Mueble.

---

---

---

# RESUMEN

1. **Herencia**: Permite que una clase herede atributos y métodos de otra.

2. **Polimorfismo**: Permite que una referencia de tipo base apunte a un objeto de tipo derivado.

3. **Sobrescritura**: Redefinir un método en una subclase.

4. **Sobrecarga**: Definir múltiples métodos con el mismo nombre pero diferentes parámetros.

5. **Clases abstractas**: No se pueden instanciar, sirven como plantillas.

6. **Interfaces**: Colecciones de métodos abstractos que una clase puede implementar.
