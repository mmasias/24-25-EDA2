# **Ejercicio 3: Suma máxima**

`Problema:` Encuentre el subarreglo contiguo con suma máxima.

## **Solución (O(n))**

Utilizamos el algoritmo de Kadane.

```java
public static int sumaMaxima(int[] nums) {
    int maxActual = nums[0], maxTotal = nums[0];
    for (int i = 1; i < nums.length; i++) {
        maxActual = Math.max(nums[i], maxActual + nums[i]);
        maxTotal = Math.max(maxTotal, maxActual);
    }
    return maxTotal;
}
```

`Complejidad:` O(n) ya que recorremos el array una sola vez.

---
