# **Ejercicio 2: Producto defectuoso**

`Problema:` En una línea de producción los productos empiezan a salir defectuosos en cierto punto. Encuentre el primer producto defectuoso.

## **Solución (O(log n))**

Usamos búsqueda binaria para minimizar comparaciones.

```java
public static int primerDefectuoso(boolean[] productos) {
    int inicio = 0, fin = productos.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin) / 2;
        if (productos[medio]) {
            fin = medio;
        } else {
            inicio = medio + 1;
        }
    }
    return inicio;
}
```

`Complejidad:` O(log n), búsqueda binaria minimiza comparaciones.

---
