# **Ejercicio 2: Subconjuntos**

`Problema:` Encuentre todos los subconjuntos de un conjunto.

## **Solución (O(2^n))**

Generamos todos los subconjuntos usando recursión.

```java
public static void subconjuntos(int[] nums) {
    generarSubconjuntos(nums, new ArrayList<>(), 0);
}

private static void generarSubconjuntos(int[] nums, List<Integer> actual, int index) {
    if (index == nums.length) {
        System.out.println(actual);
        return;
    }
    generarSubconjuntos(nums, actual, index + 1);
    actual.add(nums[index]);
    generarSubconjuntos(nums, actual, index + 1);
    actual.remove(actual.size() - 1);
}
```

`Complejidad:` O(2^n) debido a la generación de todas las combinaciones posibles.
