# **Ejercicio 4: Mediana en stream**

`Problema:` Encuentre la mediana a medida que llegan números.

## **Solución (O(n log n))**

Mantenemos dos listas para los números menores y mayores a la mediana.

```java
public static void medianaEnStream(int[] nums) {
    int[] ordenados = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
        ordenados[i] = nums[i];
        ordenar(ordenados, i + 1);
        System.out.println(mediana(ordenados, i + 1));
    }
}

private static void ordenar(int[] arr, int n) {
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
    }
}

private static double mediana(int[] arr, int n) {
    if (n % 2 == 1) return arr[n / 2];
    return (arr[n / 2] + arr[(n / 2) - 1]) / 2.0;
}
```

`Complejidad:` O(n log n) en total debido a las ordenaciones sucesivas.
