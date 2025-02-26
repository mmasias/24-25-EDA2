# **Ejercicio 3: Casi ordenado**

`Problema:` Ordene un array donde cada elemento está a lo más k posiciones de su posición final.

## **Solución (O(n log k))**

Utilizamos una estrategia de ordenación parcial basada en min-heaps.

```java
public static void ordenarCasiOrdenado(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
        for (int j = Math.max(0, i - k); j < i; j++) {
            if (arr[j] > arr[i]) {
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
```

`Complejidad:` O(n log k) en promedio.

---
