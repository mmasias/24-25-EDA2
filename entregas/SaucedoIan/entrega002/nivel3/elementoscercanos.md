# K Elementos más Cercanos - Análisis de Complejidad

## Descripción del Problema

Encontrar los k elementos más cercanos a un valor objetivo en un arreglo ordenado.

## Soluciones Implementadas

### 1. Búsqueda Binaria con Dos Punteros

- **Complejidad Temporal**: O(log(n-k))
  - Búsqueda binaria en ventana deslizante
  - n: tamaño del arreglo
  - k: cantidad de elementos a encontrar
- **Complejidad Espacial**: O(1)
  - Solo variables de control
  - Arreglo resultado de tamaño k

### 2. Fuerza Bruta (Alternativa)

- **Complejidad Temporal**: O(n log n)
  - Calcular diferencias: O(n)
  - Ordenar diferencias: O(n log n)
- **Complejidad Espacial**: O(n)
  - Arreglos auxiliares para diferencias e índices

## Ejemplo de Uso

```java
int[] numeros = {1, 2, 3, 4, 5};
int k = 2;
double objetivo = 3.7;
int[] resultado = encontrarKElementosCercanos(numeros, k, objetivo);
// Resultado: [3, 4]
```
