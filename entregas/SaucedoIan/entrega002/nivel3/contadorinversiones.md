# Contador de Inversiones - Análisis de Complejidad

## Descripción del Problema

Contar el número de pares de elementos que están en orden incorrecto en un arreglo.

## Soluciones Implementadas

### 1. Fuerza Bruta

- **Complejidad Temporal**: O(n²)
  - Dos bucles anidados
  - Comparación directa de pares
- **Complejidad Espacial**: O(1)
  - Solo contador de inversiones
  - No requiere espacio adicional

### 2. Merge Sort Modificado

- **Complejidad Temporal**: O(n log n)
  - División del arreglo: log n niveles
  - Merge con conteo: n operaciones por nivel
- **Complejidad Espacial**: O(n)
  - Arrays temporales para merge sort
  - Recursión: O(log n) en la pila

## Ejemplo de Uso

```java
int[] numeros = {2, 4, 1, 3, 5};
int inversiones = contarInversionesMergeSort(numeros);
// Resultado: 3 inversiones [(2,1), (4,1), (4,3)]
```
