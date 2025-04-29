# Acerca del polimorfismo

|||
|-|-|
|El polimorfismo es un mecanismo fundamental en la programación orientada a objetos que permite tratar de manera uniforme objetos que mantienen una relación de herencia.|Contrariamente a la creencia común, el polimorfismo no hace que los objetos "cambien de forma" o se transformen; opera a nivel de referencias, no de objetos.|

---

|Qué es|Qué no es|Qué permite|Qué no permite|
|-|-|-|-|
|Un mecanismo de relajación del sistema de tipos.|No es una transformación o cambio en los objetos.|Permite que una variable declarada de un tipo referencie objetos de sus clases derivadas.|No permite que un objeto cambie su tipo o comportamiento una vez creado.|
|Una característica que opera a nivel de referencias.|No es una característica de los objetos en sí.|Permite tratar de manera uniforme objetos diferentes que comparten una jerarquía.|No permite asignar cualquier objeto a cualquier referencia (debe existir herencia).|
|Una forma de aprovechar las jerarquías de herencia.|No es una forma de evadir el sistema de tipos.|Permite escribir código más genérico y reutilizable.|No permite acceder a métodos específicos sin casting explícito.|

## Ejemplo de *correcta* implementación

```java
// Definición de la jerarquía
interface FiguraGeometrica {
    double calcularArea();
}

class Circulo implements FiguraGeometrica {
    private double radio;
    
    public Circulo(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
}

class Rectangulo implements FiguraGeometrica {
    private double base;
    private double altura;
    
    public Rectangulo(double base, double altura) {
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return base * altura;
    }
}

// Uso correcto del polimorfismo
class EditorGrafico {
    public void dibujarFigura(FiguraGeometrica figura) {
        // El método sabe trabajar con cualquier FiguraGeometrica
        double area = figura.calcularArea();
        // Lógica de dibujo...
    }
}
```

## Implicaciones y consideraciones

- Inmutabilidad del tipo: Un objeto mantiene su tipo desde su creación hasta su destrucción.
- Binding dinámico.
  - La selección del método a ejecutar se realiza en tiempo de ejecución.
  - Se basa en el tipo real del objeto, no en el tipo de la referencia.
- Restricciones de acceso.
  - Una referencia solo puede acceder a los métodos definidos en su tipo.
  - El acceso a métodos específicos requiere casting explícito (práctica no recomendada).
- Implicaciones en el diseño.
  - Favorece la extensibilidad del código.
  - Permite implementar el principio de sustitución de Liskov.
  - Facilita la inversión de dependencias.

## Variaciones y extensiones

### Polimorfismo paramétrico (Generics)

El polimorfismo paramétrico permite escribir código que funciona con diferentes tipos sin necesidad de conocerlos específicamente.

```java
// Definición genérica
class Contenedor<T> {
    private T contenido;
    
    public Contenedor(T contenido) {
        this.contenido = contenido;
    }
    
    public T obtener() {
        return contenido;
    }
}

// Uso con diferentes tipos
Contenedor<String> cs = new Contenedor<>("Hola");
Contenedor<Integer> ci = new Contenedor<>(42);
```

Características clave:

- No requiere relación de herencia entre tipos.
- Proporciona type-safety en tiempo de compilación.
- El código es reutilizable para cualquier tipo.
- Se basa en el concepto de "tipo como parámetro".

### Polimorfismo ad-hoc (Sobrecarga)

Permite que un nombre represente múltiples operaciones diferentes.

```java
class Calculadora {
    // Sobrecarga de métodos
    public int sumar(int a, int b) {
        return a + b;
    }
    
    public double sumar(double a, double b) {
        return a + b;
    }
    
    public String sumar(String a, String b) {
        return a + b;  // Concatenación
    }
}
```

Características clave:

- La selección del método se hace en tiempo de compilación
- Se basa en los tipos de los parámetros
- No requiere herencia
- Cada implementación puede ser completamente diferente
- No hay binding dinámico

### Polimorfismo de coerción (Conversión de tipos)

Es un mecanismo que permite que una operación diseñada para un tipo acepte argumentos de otro tipo, realizando una conversión automática. Esta conversión puede ser:

#### Implícita (widening)

Conversiones seguras que Java realiza automáticamente.

```java
int i = 42;
long l = i;    // int -> long
float f = l;   // long -> float
double d = f;  // float -> double
```

#### Explícita (narrowing)

Requieren cast explícito por riesgo de pérdida de información.

```java
double d = 42.5;
float f = (float) d;  // Posible pérdida de precisión
int i = (int) f;      // Pérdida de parte decimal
```

#### Entre tipos de objetos

Basada en la jerarquía de clases.

```java
Integer i = 42;
Number n = i;               // Implícita (widening)
Integer i2 = (Integer) n;   // Explícita (narrowing)
```

#### Personalizada

Definida por el programador.

```java
class Celsius {
    private double temperatura;
    
    public Celsius(double temp) {
        this.temperatura = temp;
    }
    
    // Conversión explícita a Fahrenheit
    public Fahrenheit toFahrenheit() {
        return new Fahrenheit(temperatura * 9/5 + 32);
    }
}
```

Características clave:

- Es parte del sistema de tipos de Java
- Puede ser automática (implícita) o requerir intervención del programador (explícita)
- Las conversiones implícitas siempre son seguras
- Las conversiones explícitas pueden producir pérdida de información o excepciones
- No está relacionado con el polimorfismo de subtipos ni con el binding dinámico
- Opera en tiempo de compilación, no en tiempo de ejecución

### Comparación y uso conjunto

Estos diferentes tipos de polimorfismo a menudo se utilizan juntos:

```java
class Procesador<T extends Number> {  // Polimorfismo paramétrico con restricción
    public double procesar(T valor) {  // Polimorfismo de subtipo
        return valor.doubleValue();    // Polimorfismo de coerción
    }
    
    public double procesar(T valor1, T valor2) {  // Polimorfismo ad-hoc
        return procesar(valor1) + procesar(valor2);
    }
}
```
