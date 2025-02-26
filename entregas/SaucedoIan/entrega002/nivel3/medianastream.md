# Mediana en Stream - Análisis de Complejidad

## Descripción del Problema

Calcular la mediana de un conjunto de números a medida que llegan en un flujo de datos.

## Solución Implementada

### Inserción Ordenada

- **Complejidad Temporal**:
  - Inserción: O(n) - desplazamiento de elementos
  - Obtener Mediana: O(1) - acceso directo
- **Complejidad Espacial**: O(n)
  - Almacenamiento del arreglo ordenado
  - n = cantidad total de elementos

### Características del Algoritmo

1. Mantiene arreglo ordenado en todo momento
2. Acceso directo a la mediana
3. Maneja casos pares e impares
4. No requiere estructuras adicionales

## Ejemplo de Uso

```java
MedianaStream mediana = new MedianaStream(10);
mediana.insertar(1);  // Mediana: 1.0
mediana.insertar(3);  // Mediana: 2.0
mediana.insertar(2);  // Mediana: 2.0
mediana.insertar(4);  // Mediana: 2.5
mediana.insertar(5);  // Mediana: 3.0
```
