# **Ejercicio 4: Array "montaña"**

`Problema:` Verifique si un array es una montaña (primero estrictamente creciente y luego estrictamente decreciente).

## **Solución (O(n))**

Recorremos el array buscando el pico y verificamos las dos condiciones.

```java
public static boolean esMontana(int[] arr) {
    if (arr.length < 3) return false;
    int i = 0;
    while (i < arr.length - 1 && arr[i] < arr[i + 1]) i++;
    if (i == 0 || i == arr.length - 1) return false;
    while (i < arr.length - 1 && arr[i] > arr[i + 1]) i++;
    return i == arr.length - 1;
}
```

`Complejidad:` O(n), recorremos el array una sola vez.

---
