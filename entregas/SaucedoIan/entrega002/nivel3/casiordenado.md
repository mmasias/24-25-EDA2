# Ordenamiento de Array Casi Ordenado - Análisis de Complejidad

## Descripción del Problema

Ordenar un array donde cada elemento está a lo más k posiciones de su posición final ordenada.

## Solución Implementada

### Algoritmo de Ventana Deslizante

- **Complejidad Temporal**: O(n \* k)
  - n iteraciones sobre el array
  - Búsqueda de mínimo en ventana de tamaño k
- **Complejidad Espacial**: O(1)
  - Ordenamiento in-place
  - Solo variables temporales

### Característica Clave

- Aprovecha que los elementos están cerca de su posición final
- Ventana de búsqueda reducida (k+1 elementos)
- Swap para colocar elementos en su posición

## Ejemplo de Uso

```java
int[] numeros = {2, 1, 3, 5, 4};
int k = 2;
ordenarCasiOrdenado(numeros, k);
// Resultado: [1, 2, 3, 4, 5]
```
