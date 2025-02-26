# **Ejercicio 2: K elementos más cercanos**

`Problema:` Encuentre los k números más cercanos a un valor dado.

## **Solución (O(n log n))**

Ordenamos el array por proximidad al objetivo.

```java
public static int[] kElementosCercanos(int[] nums, int k, double target) {
    ordenarPorDiferencia(nums, target);
    int[] resultado = new int[k];
    for (int i = 0; i < k; i++) {
        resultado[i] = nums[i];
    }
    return resultado;
}

private static void ordenarPorDiferencia(int[] arr, double target) {
    for (int i = 0; i < arr.length - 1; i++) {
        for (int j = 0; j < arr.length - i - 1; j++) {
            if (Math.abs(arr[j] - target) > Math.abs(arr[j + 1] - target)) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}
```

`Complejidad:` O(n log n) debido a la ordenación.

---
