# Simulación de Banco con Herencia y Polimorfismo

Este proyecto simula un banco con cuentas bancarias utilizando herencia y polimorfismo en Java. A continuación, se explica cómo se implementan estos conceptos en el código.

## Diagrama de clases
![](/entregas/castilloCayetano/images/DdC-Banco.svg)
## Clases y [Herencia](https://dev.java/learn/inheritance/what-is-inheritance/)

### Clase Banco

La clase `Banco` es la clase base que define métodos genéricos para realizar operaciones bancarias.

```java
public class Banco {
    public void realizarOperacion() {
        System.out.println("Operación bancaria genérica");
    }

    public void ingresarDinero(Cuenta cuenta, double cantidad) {
        cuenta.ingresarDinero(cantidad);
        System.out.println("Ingresar " + cantidad + " dinero en la cuenta " + cuenta.getNumeroCuenta());
    }

    public void sacarDinero(Cuenta cuenta, double cantidad) {
        cuenta.sacarDinero(cantidad);
        System.out.println("Sacar " + cantidad + " dinero de la cuenta " + cuenta.getNumeroCuenta());
    }

    public void consultarSaldo(Cuenta cuenta) {
        System.out.println("El saldo de la cuenta " + cuenta.getNumeroCuenta() + " es " + cuenta.getSaldo());
    }
}
```
### Clase Cajero 

La clase `Cajero` extiende la clase Banco y sobrescribe el método realizarOperacion proporcionando una implementación especifica.

```java
public class Cajero extends Banco {
    @Override
    public void realizarOperacion() {
        System.out.println("Operación en el cajero");
    }

    @Override
    public void ingresarDinero(Cuenta cuenta, double cantidad) {
        super.ingresarDinero(cuenta, cantidad);
    }

    @Override
    public void sacarDinero(Cuenta cuenta, double cantidad) {
        super.sacarDinero(cuenta, cantidad);
    }
}

```
### Clase Aplicacion
La clase `Aplicacion` también extiende la clase Banco y sobrescribe el método realizarOperacion.

```java
public class Aplicacion extends Banco {
    @Override
    public void realizarOperacion() {
        System.out.println("Operación en la aplicación");
    }

    @Override
    public void consultarSaldo(Cuenta cuenta) {
        super.consultarSaldo(cuenta);
    }
}

```

## [Polimorfismo](https://dev.java/learn/inheritance/polymorphism/)


### Clase Main

En el método main de la clase `Main`, se demuestra el uso de polimorfismo. 
Se crean instancias de Banco, Cajero y Aplicacion, y se llama al método realizarOperacion en cada una de ellas.

```java
public class Main {
    public static void main(String[] args) {
        Interfaz interfaz = new Interfaz();
        interfaz.iniciar();
    }
}
