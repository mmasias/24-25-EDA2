# Un sistema de notificaciones

## ¿Por qué?

En programación, es común encontrarnos con situaciones donde necesitamos manejar diferentes variantes de una misma operación. La solución más directa suele ser algo así:

```java
class GestorNotificaciones {
    public void enviarNotificacion(String tipo, String mensaje, String destinatario) {
        if (tipo.equals("email")) {
            System.out.println("Enviando email a " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        } else if (tipo.equals("sms")) {
            System.out.println("Enviando SMS a " + destinatario);
            System.out.println("Mensaje: " + mensaje);
        }
    }
}
```

Esta aproximación presenta problemas fundamentales:

1. Código que crece sin control.
    - Cada nueva variante requiere modificar el código existente
    - El método crece indefinidamente
1. Código frágil
   - Los cambios en una variante pueden afectar accidentalmente a otras
   - Alto riesgo de errores al modificar el código
1. Difícil de mantener
   - La lógica de todas las variantes está mezclada
   - Difícil de entender y modificar
1. Difícil de probar
   - Hay que probar todo el método cada vez que se hace un cambio
   - No se pueden probar las variantes de forma aislada

## ¿Qué?

Para ilustrar este problema y su solución, consideremos un sistema de notificaciones donde:

- Los usuarios necesitan recibir notificaciones
- Existen diferentes métodos de notificación (email, SMS...)
- Cada usuario puede preferir un método diferente
- El sistema debe poder incorporar nuevos métodos en el futuro
- Se debe poder cambiar el método de notificación en cualquier momento

Este escenario representa perfectamente el patrón que queremos resolver: diferentes variantes de un mismo concepto (la notificación) que comparten un comportamiento básico pero lo implementan de manera diferente.

## ¿Para qué?

Necesitamos una solución que:

|Permita la extensión sin modificación|Mejore la mantenibilidad|Facilite las pruebas|Proporcione flexibilidad|
|-|-|-|-|
|Añadir nuevos tipos de notificación sin tocar el código existente.|Cada tipo de notificación debe ser independiente.|Debe ser fácil probar cada tipo de notificación por separado.|Cambiar tipos de notificación en tiempo de ejecución.|
|Cumplir con el principio Open/Closed.|Los cambios en un tipo no deben afectar a otros.|Debe permitir la creación de implementaciones de prueba.|Combinar diferentes tipos de notificación.|

## ¿Cómo?

El polimorfismo nos proporciona las herramientas para lograr todos estos objetivos.

### Definir la interfaz común

Primero, establecemos el contrato que toda notificación debe cumplir:

```java
public interface Notificacion {
    void enviar(String mensaje, String destinatario);
}
```

### Implementar las clases concretas

Cada tipo de notificación implementa la interfaz según sus necesidades:

```java
public class NotificacionEmail implements Notificacion {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Conectando con servidor SMTP...");
        System.out.println("Enviando email a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}

public class NotificacionSMS implements Notificacion {
    @Override
    public void enviar(String mensaje, String destinatario) {
        System.out.println("Conectando con proveedor SMS...");
        System.out.println("Enviando SMS a: " + destinatario);
        System.out.println("Mensaje: " + mensaje);
    }
}
```

### El gestor de notificaciones

```java
public class GestorNotificaciones {
    private Notificacion notificador;
    
    public GestorNotificaciones(Notificacion notificador) {
        this.notificador = notificador;
    }
    
    public void enviarNotificacion(String mensaje, String destinatario) {
        notificador.enviar(mensaje, destinatario);
    }
    
    public void cambiarTipoNotificacion(Notificacion nuevoNotificador) {
        this.notificador = nuevoNotificador;
    }
}
```

### El sistema

```java
class EjemploUso {
    public static void main(String[] args) {
        
        GestorNotificaciones gestor = new GestorNotificaciones(new NotificacionEmail());
        gestor.enviarNotificacion("Bienvenido al sistema", "usuario@email.com");
       
        gestor.cambiarTipoNotificacion(new NotificacionSMS());        
        gestor.enviarNotificacion("Su código es 123456", "+34666777888");
    }
}
```

## Ejercicios propuestos

### Implementación base

- Implemente el sistema tal como se ha mostrado.
- Añada mensajes de log apropiados.
- Pruebe diferentes combinaciones de notificaciones.

### Extensión

- Añada una nueva clase `NotificacionTelegram`.
- Implemente un método para enviar la misma notificación por múltiples canales.
- Añada validación de destinatarios según el tipo de notificación.

### Mejoras

- Implemente un sistema de prioridad para las notificaciones.
- Cree un registro de notificaciones enviadas.

## *2Think*

1. ¿Por qué es mejor esta solución que la original?
1. ¿Cómo manejaría los errores en cada tipo de notificación?
1. ¿Qué otros métodos podrían añadirse a la interfaz `Notificacion`?

> El objetivo de este ejemplo es comprender cómo el polimorfismo nos permite tratar de manera uniforme objetos que comparten un comportamiento común, aunque la implementación específica de ese comportamiento varíe.
