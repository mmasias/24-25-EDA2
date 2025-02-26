# Array Montaña - Análisis de Complejidad

## Descripción del Problema

Verificar si un arreglo es una "montaña": primero estrictamente creciente y luego estrictamente decreciente.

## Solución Implementada

### Algoritmo de Verificación - O(n)

1. Encontrar punto máximo (pico)
2. Verificar secuencia creciente hasta el pico
3. Verificar secuencia decreciente desde el pico

### Complejidad

- **Temporal**: O(n)
  - Un solo recorrido del arreglo
  - Verificación lineal
- **Espacial**: O(1)
  - Solo variables de control
  - No requiere espacio adicional

## Ejemplo de Uso

```java
int[] montana = {1, 3, 5, 4, 2};
boolean esMontana = esMontana(montana); // Retorna true
```
