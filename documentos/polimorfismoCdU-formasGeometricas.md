# Formas geométricas

## ¿Por qué?

Imagine que está desarrollando una aplicación de dibujo donde necesita manejar diferentes formas geométricas. 

La solución "más directa" podría ser algo así:

```java
class GestorFormas {
    public double calcularAreaCirculo(double radio) {
        return Math.PI * radio * radio;
    }
    
    public double calcularAreaRectangulo(double base, double altura) {
        return base * altura;
    }

    public void dibujarCirculo(String color, double radio) {
        System.out.println("Dibujando círculo " + color);
        (...)
    }
    
    public void dibujarRectangulo(String color, double base, double altura) {
        System.out.println("Dibujando rectángulo " + color);
        (...)
    }
    
    (...)
}
```

Esta aproximación presenta problemas serios:

|Código repetitivo y desordenado|Difícil de mantener|Código poco robusto|Lógica duplicada|
|-|-|-|-|
|Cada nueva forma requiere modificar múltiples métodos.|Los parámetros son difíciles de manejar.|No hay garantía de que se pasen los parámetros correctos.|Las propiedades comunes (como el color) se repiten en cada caso.|
|La lógica de cada forma está dispersa en diferentes métodos.|Fácil cometer errores al añadir nuevas formas.|Difícil de verificar y validar.|No hay forma de compartir comportamiento entre formas.|

## ¿Qué?

En un programa de dibujo, las formas geométricas:

|Comparten características|Sin embargo, cada forma|Siendo este es un caso donde tenemos|
|-|-|-|
|Todas tienen un color.|Se dibuja de manera diferente.|Comportamiento común que podemos compartir.|
|Todas se pueden dibujar.|Calcula su área de forma distinta.|Comportamiento específico que cada forma debe implementar.|
|Todas ocupan un área.|Necesita diferentes datos (radio, base, altura...).|Necesidad de tratar todas las formas de manera uniforme.|
|Todas tienen un perímetro.|||

## ¿Para qué?

Necesitamos una solución que:

|Organice el código de forma lógica|Sea fácil de extender|Evite errores|Facilite el uso|
|-|-|-|-|
|Mantener junto todo lo relacionado con cada forma.|Añadir nuevas formas sin modificar código existente.|Asegurar que cada forma tenga todos sus datos necesarios.|Tratar todas las formas de manera uniforme.|
|Compartir código común entre formas.|Garantizar que las nuevas formas implementen todo lo necesario.|Validar los datos al crear las formas.|Permitir colecciones de formas mixtas.|

## ¿Cómo?

### Crear la clase abstracta base

```java
public abstract class Forma {
    protected String color;
    
    public Forma(String color) {
        this.color = color;
    }
    
    public String getColor() {
        return color;
    }
    
    public abstract double calcularArea();
    public abstract double calcularPerimetro();
    public abstract void dibujar();
}
```

### Implementar las clases

```java
public class Circulo extends Forma {
    private double radio;
    
    public Circulo(String color, double radio) {
        super(color);
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * radio * radio;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * radio;
    }
    
    @Override
    public void dibujar() {
        System.out.println("Dibujando círculo " + color + " con radio " + radio);
    }
}

public class Rectangulo extends Forma {
    private double base;
    private double altura;
    
    public Rectangulo(String color, double base, double altura) {
        super(color);
        this.base = base;
        this.altura = altura;
    }
    
    @Override
    public double calcularArea() {
        return base * altura;
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * (base + altura);
    }
    
    @Override
    public void dibujar() {
        System.out.println("Dibujando rectángulo " + color + " de " + base + "x" + altura);
    }
}
```

### Implementar el sistema

```java
public class EjemploUso {
    public static void main(String[] args) {
        
        Forma circulo = new Circulo("rojo", 5);
        Forma rectangulo = new Rectangulo("azul", 4, 6);
        
        System.out.println("Área del círculo: " + circulo.calcularArea());
        System.out.println("Área del rectángulo: " + rectangulo.calcularArea());
        
        Forma[] formas = {circulo, rectangulo};
        for (Forma forma : formas) {
            forma.dibujar();
            System.out.println("Perímetro: " + forma.calcularPerimetro());
        }
    }
}
```

## Ejercicios propuestos

### Implementación base

- Implemente el sistema tal como se ha mostrado.
- Añada una nueva forma (por ejemplo, Triángulo).
- Cree un método que calcule el área total de un conjunto de formas.

### Extensión

- Añada nuevas propiedades comunes (por ejemplo, posición x,y).
- Implemente un método para mover las formas.
- Añada validación de parámetros en los constructores.

### Mejoras

- Implemente una forma compuesta (que contenga otras formas).
- Añada la capacidad de rotar las formas.
- Cree un método para detectar colisiones entre formas.

## *2Think*

1. ¿Qué ventajas ofrece usar una clase abstracta en lugar de una interfaz?.
1. ¿Cómo manejaría formas irregulares?.
1. ¿Qué otros métodos comunes podrían añadirse a la clase Forma?.
1. ¿Cómo implementaría la capacidad de deshacer/rehacer operaciones?.

> La clase abstracta Forma nos permite compartir código común (color, métodos auxiliares) mientras forzamos a las clases concretas a implementar su comportamiento específico (cálculo de área, dibujo).