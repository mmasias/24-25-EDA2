# 🚬

## Obvio...

```java
class Animal {
    public void hacerSonido() {
        System.out.println("???");
    }
}

Animal animal1 = new Animal();
```

Esto parece obvio: una referencia de tipo Animal puede guardar un objeto Animal. Esta es la base desde la que construiremos nuestra comprensión.

## No tan obvio

Cuando introducimos herencia, las cosas empiezan a ponerse interesantes:

```java
class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau!");
    }
}

Animal animal2 = new Gato();
animal2.hacerSonido();
```

¿Qué imprimirá este código? "Miau!", no "???". 

Esto nos lleva a nuestra primera revelación importante: aunque usemos una referencia de tipo Animal, el comportamiento específico del objeto Gato se mantiene.

## Límites de lo flexible

Sin embargo, no todo está permitido:

```java
Gato gato = new Animal();  // Error de compilación
```

Este error nos revela una asimetría fundamental en el sistema de tipos: mientras que una referencia más general puede apuntar a algo más específico, lo contrario no es cierto.

## Dualidad de las referencias

La situación se vuelve más intrigante cuando añadimos comportamiento específico:

```java
class Gato extends Animal {
    @Override
    public void hacerSonido() {
        System.out.println("Miau!");
    }
    
    public void ronronear() {
        System.out.println("Prrrrr");
    }
}

Animal animal3 = new Gato();
animal3.hacerSonido();   // Funciona
animal3.ronronear();     // Error de compilación
```

Este caso ilustra la dualidad entre el tipo de la referencia y el tipo del objeto: el objeto mantiene todas sus capacidades, pero solo podemos acceder a ellas según el tipo de la referencia que usemos.

## ¿Arrays?

Los arrays añaden una capa adicional de complejidad:

```java
Animal[] animales = new Gato[3];  // Esto compila
animales[0] = new Gato();         // OK
animales[1] = new Animal();       // RuntimeException
```

Este comportamiento aparentemente contradictorio nos revela aspectos sutiles sobre cómo Java maneja la covarianza en arrays.

## instanceof == 💩

El operador instanceof nos lleva a cuestionar nuestro diseño:

```java
Animal animal = new Gato();
if (animal instanceof Gato) {
    Gato gato = (Gato) animal;
    gato.ronronear();
}
```

La necesidad de usar `instanceof` suele ser un "smell" que indica un problema de diseño. Un mejor enfoque sería:

```java
abstract class Animal {
    abstract void mostrarFelicidad();
}

class Gato extends Animal {
    @Override
    void mostrarFelicidad() {
        ronronear();
    }
    
    private void ronronear() {
        System.out.println("Prrrrr");
    }
}
```

## equals

La igualdad en presencia de polimorfismo plantea preguntas interesantes:

```java
Gato gato1 = new Gato();
Animal animal1 = gato1;
System.out.println(gato1.equals(animal1));
```

Este caso nos lleva a reflexionar sobre la identidad de los objetos versus sus referencias.

## Cadena de herencia

El uso de super añade otra capa de complejidad:

```java
class GatoMalevolo extends Gato {
    @Override
    public void hacerSonido() {
        super.hacerSonido();
        System.out.println("¡Muahaha!");
    }
}
```

¿A qué implementación de hacerSonido() llamará super? Este caso nos ayuda a entender la cadena de resolución de métodos.

## Interfaz diabólica

Finalmente, la interacción entre interfaces y herencia de clases revela más sutilezas:

```java
interface Sonoro {
    void hacerSonido();
}

class Animal {
    public void hacerSonido() {
        System.out.println("???");
    }
}

class Gato extends Animal implements Sonoro {
    // ¿Necesitamos implementar hacerSonido()?
}
```

La respuesta depende de varios factores:

1. La visibilidad del método en Animal
1. La coincidencia exacta de las firmas de los métodos
1. La compatibilidad de los tipos de retorno

Variaciones que fuerzan la implementación:

```java
class Animal {
    private void hacerSonido() {  // Ahora es private
        System.out.println("???");
    }
}

interface Sonoro {
    String hacerSonido();  // Cambia el tipo de retorno
}
```
