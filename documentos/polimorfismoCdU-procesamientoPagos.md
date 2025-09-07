# Sistema de pagos

## ¿Por qué?

Imagine que está desarrollando el sistema de pagos de una tienda online. Los clientes quieren poder pagar con diferentes métodos: tarjeta de crédito, PayPal, transferencia bancaria... La solución inicial podría ser:

```java
class SistemaPagos {
    public void procesarPagoTarjeta(double monto, String numeroTarjeta, String fechaExpiracion) {
        System.out.println("Conectando con el banco...");
        System.out.println("Verificando tarjeta: " + numeroTarjeta);
        System.out.println("Procesando pago de " + monto + "€");
        (...)
    }

    public void procesarPagoPayPal(double monto, String emailPayPal) {
        System.out.println("Conectando con PayPal...");
        System.out.println("Usuario: " + emailPayPal);
        System.out.println("Procesando pago de " + monto + "€");
        (...)
    }

    public void procesarPagoTransferencia(double monto, String numeroCuenta) {
        System.out.println("Preparando transferencia bancaria...");
        System.out.println("Cuenta: " + numeroCuenta);
        System.out.println("Procesando pago de " + monto + "€");
        (...)
    }
}
```

Esta aproximación presenta varios problemas:

|Código rígido y repetitivo|Difícil de mantener|Sistema poco flexible|Lógica de negocio dispersa|
|-|-|-|-|
|Cada nuevo método de pago requiere un nuevo método.|Los cambios en el proceso de pago afectan a múltiples métodos.|Cada cambio en un método de pago afecta a todo el sistema.|Las reglas de validación están repetidas.|
|Mucho código repetido en las verificaciones y logs.|No hay una estructura clara para manejar errores.|Difícil añadir o modificar formas de pago.|Difícil asegurar consistencia entre métodos de pago.|

## ¿Qué?

En un sistema de pagos:

- Todos los pagos tienen un monto.
- Todos los pagos siguen un proceso similar.
- Lo único que cambia es cómo se procesa cada tipo de pago.
- Necesitamos poder añadir nuevos métodos de pago fácilmente.

Es un escenario donde:

- El proceso básico es similar.
- Los detalles de implementación varían.
- La flexibilidad es esencial.

## ¿Para qué?

Necesitamos una solución que:

|Simplifique el código|Sea fácil de ampliar|Sea fácil de mantener|Sea flexible|
|-|-|-|-|
|Un solo método para procesar cualquier pago.|Añadir nuevos métodos de pago sin tocar lo que ya existe.|Cambios en un método de pago no afectan a los demás.|Poder cambiar entre métodos de pago fácilmente.|
|Cada tipo de pago maneja sus propios detalles.|Cada método de pago se puede trabajar por separado.|Código organizado y fácil de entender.|Tratar todos los pagos de la misma manera.|

## ¿Cómo?

### Definir la interfaz de pago

```java
public interface ProcesadorPago {
    boolean procesar(double monto);
}
```

### Implementar las clases

```java
class ProcesadorTarjeta implements ProcesadorPago {
    @Override
    public boolean procesar(double monto) {
        System.out.println("Cobrando " + monto + "€ con tarjeta");
        (...)
    }
}

class ProcesadorPayPal implements ProcesadorPago {
    @Override
    public boolean procesar(double monto) {
        System.out.println("Cobrando " + monto + "€ con PayPal");
        (...)
    }
}
```

### El gestor de pagos

```java
public class Tienda {
    private ProcesadorPago procesador;
    
    public void setProcesador(ProcesadorPago nuevoProcesador) {
        this.procesador = nuevoProcesador;
    }
    
    public boolean realizarCobro(double monto) {
        return procesador.procesar(monto);
    }
}
```

### El sistema

```java
public class EjemploUso {
    public static void main(String[] args) {

        Tienda tienda = new Tienda();
        
        tienda.setProcesador(new ProcesadorTarjeta());
        boolean cobro = tienda.realizarCobro(100.0);
        
        tienda.setProcesador(new ProcesadorPayPal());
        cobro = tienda.realizarCobro(50.0);
    }
}
```

## Ejercicios propuestos

### Implementación base

- Implemente el sistema mostrado.
- Añada validación de montos negativos.
- Implemente un nuevo método de pago (transferencia).

### Extensión

- Añada encriptación de datos sensibles.
- Implemente límites de monto por método.
- Añada validación de intentos fallidos.

### Mejoras

- Implemente pagos en diferentes monedas.
- Añada procesamiento asíncrono.
- Implemente reintentos automáticos.

## *2Think*

1. ¿Cómo manejaría pagos parciales o en cuotas?
1. ¿Qué estrategia usaría para pagos internacionales?
1. ¿Cómo implementaría un sistema de reembolsos?
1. ¿Qué consideraciones de seguridad adicionales añadiría?

> El polimorfismo nos permite crear sistemas flexibles y mantenibles en un contexto empresarial real, donde la seguridad, la auditabilidad y la robustez son fundamentales.
