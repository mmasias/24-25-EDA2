# Producto Defectuoso - Análisis de Complejidad

## Descripción del Problema

Encontrar el primer producto defectuoso en una línea de producción donde los productos defectuosos aparecen consecutivamente después de cierto punto.

## Solución Implementada

### Búsqueda Binaria

- **Complejidad Temporal**: O(log n)
  - División del espacio de búsqueda por 2 en cada paso
  - log n pasos para encontrar el primer defectuoso
- **Complejidad Espacial**: O(1)
  - Solo variables para índices
  - No requiere espacio adicional

### Características

1. Aprovecha el orden de los productos
2. Encuentra el punto exacto de cambio
3. Eficiente para grandes conjuntos
4. No requiere recorrer toda la línea

## Ejemplo de Uso

```java
boolean[] productos = {false, false, false, true, true};
int posicion = encontrarPrimerDefectuoso(productos);
// Resultado: 3 (índice del primer true)
```
