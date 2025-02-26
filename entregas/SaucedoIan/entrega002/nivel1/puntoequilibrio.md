# Punto de Equilibrio - Análisis de Complejidad

## Descripción del Problema

Encontrar el índice donde la suma de los elementos a la izquierda es igual a la suma de los elementos a la derecha.

## Soluciones Implementadas

### 1. Fuerza Bruta

- **Complejidad Temporal**: O(n²)
  - Bucle externo: n iteraciones
  - Bucles internos: n iteraciones para sumas
- **Complejidad Espacial**: O(1)
  - Solo variables para sumas parciales

### 2. Solución Optimizada

- **Complejidad Temporal**: O(n)
  - Primer recorrido: suma total O(n)
  - Segundo recorrido: verificación O(n)
- **Complejidad Espacial**: O(1)
  - Variables para suma total y parcial

## Ejemplo de Uso

```java
int[] numeros = {1, 2, 3, 4, 6};
int equilibrio = encontrarEquilibrioOptimizado(numeros); // Retorna 3
```
