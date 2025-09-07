# Polimorfismo

```java
Animal miAnimal;
```

## ¿Por qué?

En el mundo real tratamos constantemente con objetos que, aunque diferentes, comparten características que nos permiten interactuar con ellos de manera similar según el contexto. 

> Por ejemplo, un veterinario trata con diferentes tipos de animales - aunque cada uno tiene sus particularidades, todos pueden ser examinados, alimentados y tratados como "animales" en el contexto de una consulta veterinaria.

La Programación Orientada a Objetos, al intentar modelar el mundo real, necesita reflejar esta capacidad de tratar de manera uniforme objetos que comparten características comunes: necesitamos poder escribir código que pueda trabajar con diferentes tipos de objetos sin necesidad de conocer sus particularidades específicas.

## ¿Qué?

El polimorfismo es un mecanismo que permite tratar de manera uniforme objetos que mantienen una relación de herencia entre ellos. En Java, este mecanismo se materializa a través del sistema de referencias, permitiendo que una variable declarada de un tipo pueda referenciar objetos que hereden de ese tipo.

Por ejemplo, en nuestro sistema veterinario:

```java
Animal miAnimal;
miAnimal = new Gato();
miAnimal = new Perro();
```

Lo fundamental es que el objeto mantiene su comportamiento específico aunque lo tratemos a través de una referencia más general:

```java
miAnimal.comer();
```

## ¿Para qué?

El polimorfismo nos proporciona dos beneficios fundamentales:

1. Escribir código más flexible y reutilizable.
1. Diseñar sistemas fácilmente extensibles.

Por ejemplo, en nuestro sistema veterinario, estos beneficios se materializan permitiendo que:

- Un veterinario pueda examinar cualquier animal sin necesidad de saber su tipo específico.
- Se puedan añadir nuevos tipos de animales sin modificar el código existente de la clínica.
- Los tratamientos se puedan definir de manera general pero aplicarse de forma específica según el tipo de animal.

## ¿Cómo?

### Base técnica del polimorfismo

El polimorfismo es una **relajación del sistema de tipos**, de tal manera que una referencia declarada de una clase (atributo, parámetro o declaración local o elemento de un vector) acepta la asignación de la dirección de un objeto de dicha clase o de alguna de sus clases derivadas (hija, nieta,…​)

Esto implica dos aspectos fundamentales:

- Exije la existencia de una jerarquía de clasificación mediante relaciones de herencia.
- Pero las jerarquías de clasificación NO exigen tratamientos polimòrficos.

### Naturaleza dual de objetos y referencias

Consideremos este ejemplo:

```java
Animal animal;
animal = new Gato();     // OK
animal = new Perro();    // OK

Gato gato;
gato = new Gato();       // OK
gato = new Perro();      // ERROR!!! Perro no es un Gato
```

Este código ilustra dos principios fundamentales:

- Un objeto se crea de una clase y siempre será de esa clase
- Una referencia puede, en diferentes momentos, apuntar a objetos de diferentes clases (siempre que exista una relación de herencia apropiada)

Esta dualidad es especialmente relevante cuando trabajamos con clases abstractas:

- El polimorfismo nos permite declarar referencias a clases abstractas.
- Estas referencias almacenarán direcciones de objetos de clases concretas derivadas.
- Las clases abstractas no son instanciables, pero sus referencias son útiles para el tratamiento polimórfico.

### Sistema de referencias

El polimorfismo se construye sobre el sistema de referencias de Java: este es el fundamento técnico que hace posible el polimorfismo:

```java
Animal miAnimal = new Gato("Felix");

```

<div align=center>

|||
|:-:|-|
|`Animal miAnimal`|Declara una variable que puede guardar una referencia a *algo que sea Animal*.|
|`new Gato("Felix")`|Crea un objeto Gato en memoria.|
|`=`|Hace que la variable guarde la referencia al objeto Gato.|


</div>

### Jerarquía de tipos

Para que el polimorfismo funcione, necesitamos establecer relaciones entre tipos, relaciones de herencia. En Java, esto se puede hacer de dos formas que, aunque sintácticamente diferentes, establecen la misma relación:

<div align=center>

<table>
<tr>
<th><code>extends</code></th>
<th><code>implements</code></th>
</tr>
<tr>
<td>

```java

class Animal {
    public void comer() { }
}
class Gato extends Animal { }

```
</td>
<td>

```java
interface Animal {
    void comer();
}
class Gato implements Animal { }
```
</td>
</tr>
</table>

</div>

En ambos casos, se establece una relación de herencia que permite el polimorfismo.

```java
interface Animal {
    void comer();
    void emitirSonido();
}

class Gato implements Animal {
    @Override
    public void comer() {
        System.out.println("Como atún");
    }
    
    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
    
    public void jugarConOvilloLana() {
        System.out.println("Juego con ovillo");
    }
}
```

### Binding dinámico

Es el mecanismo que asegura que se ejecute el método correcto. Java determina **en tiempo de ejecución** qué método debe invocar basándose en el tipo real del objeto.

```java
Animal animal1 = new Gato();
Animal animal2 = new Perro();

animal1.emitirSonido();    // Imprime "Miau"
animal2.emitirSonido();    // Imprime "Guau"
```

### Consideraciones importantes

Una referencia solo puede usar los métodos definidos en su tipo

```java
Animal miGato = new Gato();
miGato.comer();              // OK - definido en Animal
miGato.jugarConOvilloLana(); // Error - no definido en Animal
```

Aunque Java permite el uso de `instanceof` para verificar y convertir tipos:

```java
if (miAnimal instanceof Gato) {
    Gato gato = (Gato) miAnimal;
    gato.jugarConOvilloLana();
}
```

Es importante notar que el uso de `instanceof` generalmente indica un problema en el diseño de nuestro código. Si nos encontramos necesitando verificar el tipo específico de un objeto, probablemente estamos:

1. Rompiendo el principio del polimorfismo.
1. Creando código frágil que requerirá modificaciones con cada nuevo tipo.
1. Intentando acceder a comportamiento específico que debería estar encapsulado de otra manera.

En lugar de usar `instanceof`, deberíamos repensar nuestro diseño para aprovechar mejor el polimorfismo y la encapsulación.

### Casos de uso

A continuación, ejemplos que sirvan como introducción y guía.

- [Un sistema de notificaciones](polimorfismoCdU-sistemaNotificaciones.md)
- [Formas geométricas](polimorfismoCdU-formasGeometricas.md)
- [Procesamiento de pagos](polimorfismoCdU-procesamientoPagos.md)

