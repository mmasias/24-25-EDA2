# Combinación de Arrays Ordenados - Análisis de Complejidad

## Descripción del Problema

Combinar k arrays ordenados en un único array ordenado.

## Soluciones Implementadas

### 1. Combinación Iterativa

- **Complejidad Temporal**: O(n \* k)
  - k arrays de longitud n cada uno
  - Combinar arrays de dos en dos
  - Total elementos a procesar: n \* k
- **Complejidad Espacial**: O(n \* k)
  - Array resultado para almacenar todos los elementos
  - Arrays temporales durante la combinación

### 2. Alternativa: Divide y Vencerás

- **Complejidad Temporal**: O(n \* log k)
  - Dividir en pares de arrays
  - Altura del árbol de recursión: log k
  - Trabajo por nivel: O(n)

## Ejemplo de Uso

```java
int[][] arrays = {{1,4,7}, {2,5,8}, {3,6,9}};
int[] resultado = combinarArrays(arrays);
// Resultado: [1,2,3,4,5,6,7,8,9]
```
