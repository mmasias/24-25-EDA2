# **Ejercicio 5: Pares con diferencia**

`Problema:` Encuentre todos los pares que difieren en `k`.

## **Solución (O(n log n))**

Ordenamos el array y usamos dos punteros.

```java
public static List<int[]> paresDiferencia(int[] nums, int k) {
    Arrays.sort(nums);
    List<int[]> resultado = new ArrayList<>();
    int i = 0, j = 1;
    while (j < nums.length) {
        int dif = nums[j] - nums[i];
        if (dif == k) {
            resultado.add(new int[]{nums[i], nums[j]});
            i++;
            j++;
        } else if (dif < k) {
            j++;
        } else {
            i++;
        }
    }
    return resultado;
}
```

`Complejidad:` O(n log n) debido a la ordenación previa.
