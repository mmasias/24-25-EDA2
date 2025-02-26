# **Ejercicio 4: Pico en montaña**

`Problema:` Encuentre el elemento más grande en un array que primero crece y luego decrece.

## **Solución (O(log n))**

Usamos búsqueda binaria para encontrar el pico.

```java
public static int encontrarPico(int[] nums) {
    int inicio = 0, fin = nums.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin) / 2;
        if (nums[medio] < nums[medio + 1]) {
            inicio = medio + 1;
        } else {
            fin = medio;
        }
    }
    return nums[inicio];
}
```

`Complejidad:` O(log n), búsqueda binaria en un solo pase.

## **Reto adicional:** ¿Qué pasa si hay elementos duplicados?

Modificamos la búsqueda binaria para manejar duplicados.

```java
public static int encontrarPicoDuplicados(int[] nums) {
    int inicio = 0, fin = nums.length - 1;
    while (inicio < fin) {
        int medio = (inicio + fin) / 2;
        if (nums[medio] < nums[medio + 1]) {
            inicio = medio + 1;
        } else if (nums[medio] > nums[medio + 1]) {
            fin = medio;
        } else {
            fin--;
        }
    }
    return nums[inicio];
}
```

`Complejidad:` O(log n) en el mejor caso, O(n) en caso de muchos duplicados.
