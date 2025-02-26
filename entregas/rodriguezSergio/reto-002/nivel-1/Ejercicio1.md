# **Ejercicio 1: Suma objetivo**

`Problema:` Dado un conjunto de números enteros y un entero objetivo, devuelva los índices de dos números que sumados den el objetivo.

## **Solución 1 (O(n²))**

Usamos dos bucles anidados para revisar todas las combinaciones.

```java
public static int[] sumaObjetivo(int[] nums, int objetivo) {
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == objetivo) {
                return new int[]{i, j};
            }
        }
    }
    return new int[]{-1, -1};
}
```

`Complejidad:` O(n²) debido a la doble iteración.

## **Solución 2 (O(n), una pasada)**

Se usa un enfoque de búsqueda lineal.

```java
public static int[] sumaObjetivoOptimizada(int[] nums, int objetivo) {
    int[] indices = new int[2];
    for (int i = 0; i < nums.length; i++) {
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[i] + nums[j] == objetivo) {
                indices[0] = i;
                indices[1] = j;
                return indices;
            }
        }
    }
    return new int[]{-1, -1};
}
```

`Complejidad:` O(n), una sola pasada.

---
