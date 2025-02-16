# Explicación del Código: Sistema de Doble Buffer en Java

## Introducción  
Este código implementa un sistema de doble buffer en Java para gestionar dos frames de 320x200 píxeles. Se utiliza un diseño basado en clases para manejar los frames y alternarlos eficientemente.

## Estructura del Código  

### 1. `Pixel`  
Clase que representa un píxel individual dentro de un frame. Cada píxel tiene un valor de tipo `char`.

### 2. `Frame`  
Clase que representa un frame de 320x200 píxeles utilizando una matriz de `Pixel`. Permite la manipulación de píxeles individuales.

### 3. `BufferDoble`  
Clase que mantiene dos frames y permite alternar entre ellos para evitar parpadeos al renderizar.

### 4. `Renderizador`  
Clase encargada de imprimir en consola los frames de manera legible.

### 5. `Demo`  
Clase principal que ejecuta el programa, crea un buffer doble, modifica los frames y los muestra en la consola.

## Funcionamiento  
- Se crean dos frames vacíos.  
- Se modifican algunos píxeles en cada frame.  
- Se alterna entre los frames.  
- Se renderizan los frames en consola para observar el resultado.
