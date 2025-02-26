# Generador de Subconjuntos - Análisis de Complejidad

## Descripción del Problema

Generar todos los posibles subconjuntos de un conjunto dado.

## Solución Implementada

### Algoritmo con Manipulación de Bits

- **Complejidad Temporal**: O(2^n)
  - 2^n subconjuntos posibles
  - n operaciones por subconjunto
- **Complejidad Espacial**: O(n \* 2^n)
  - Array de subconjuntos: 2^n elementos
  - Cada subconjunto hasta n elementos

### Características del Algoritmo

1. Usa representación binaria
2. Genera subconjuntos de manera sistemática
3. Implementación eficiente con bits
4. Mantiene orden original de elementos

## Ejemplo de Uso

```java
int[] conjunto = {1, 2, 3};
int[][] subconjuntos = generarSubconjuntos(conjunto);
// Salida: [], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]
```
