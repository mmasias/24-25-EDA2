# Suma Objetivo - Análisis de Complejidad

## Descripción del Problema

Dado un arreglo de números enteros y un valor objetivo, encontrar dos números en el arreglo que sumen el valor objetivo.

## Soluciones Implementadas

### 1. Fuerza Bruta

- **Complejidad Temporal**: O(n²)
  - Utiliza dos bucles anidados
  - El bucle externo: n iteraciones
  - El bucle interno: n-1, n-2, ..., 1 iteraciones
- **Complejidad Espacial**: O(1)
  - Solo usa variables temporales
  - No requiere espacio adicional que crezca con la entrada

### 2. Solución Optimizada

- **Complejidad Temporal**: O(n)
  - Un solo recorrido del arreglo
  - Cada operación de búsqueda/inserción es O(1)
- **Complejidad Espacial**: O(k)
  - k = valor máximo en el arreglo (1001 en este caso)
  - Utiliza un arreglo auxiliar de tamaño fijo

## Comparación de Rendimiento

| Aspecto       | Fuerza Bruta | Solución Optimizada |
| ------------- | ------------ | ------------------- |
| Mejor Caso    | O(1)         | O(n)                |
| Caso Promedio | O(n²)        | O(n)                |
| Peor Caso     | O(n²)        | O(n)                |
| Espacio       | O(1)         | O(k)                |

## Ejemplo de Uso

```java
int[] numeros = {3, 2, 9, 8};
int objetivo = 10;
// Resultado esperado: índices [1, 3] (2 + 8 = 10)
```
