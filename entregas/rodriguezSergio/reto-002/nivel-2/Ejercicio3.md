# **Ejercicio 3: Array rotado**

`Problema:` Encuentre el punto donde fue rotado un array originalmente ordenado.

## **Solución (O(log n))**

Usamos búsqueda binaria para encontrar el punto de rotación.

```java
public static int encontrarRotacion(int[] nums) {
    int inicio = 0, fin = nums.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin) / 2;
        if (nums[medio] > nums[fin]) {
            inicio = medio + 1;
        } else {
            fin = medio;
        }
    }
    return inicio;
}
```

`Complejidad:` O(log n), ya que dividimos la búsqueda en cada paso.

## **Reto adicional:** ¿Qué pasa si hay elementos duplicados?

Adaptamos la búsqueda binaria para casos de duplicados.

```java
public static int encontrarRotacionDuplicados(int[] nums) {
    int inicio = 0, fin = nums.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin) / 2;
        if (nums[medio] > nums[fin]) {
            inicio = medio + 1;
        } else if (nums[medio] < nums[fin]) {
            fin = medio;
        } else {
            fin--;
        }
    }
    return inicio;
}
```

`Complejidad:` O(log n) en el mejor caso, O(n) en el peor si hay muchos duplicados.

---
