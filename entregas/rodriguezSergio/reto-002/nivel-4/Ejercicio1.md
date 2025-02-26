# **Ejercicio 1: Triángulos posibles**

`Problema:` Encuentre tres números que puedan formar un triángulo.

## **Solución (O(n^2))**

Usamos tres bucles anidados para verificar la desigualdad triangular.

```java
public static boolean existeTriangulo(int[] nums) {
    int n = nums.length;
    for (int i = 0; i < n - 2; i++) {
        for (int j = i + 1; j < n - 1; j++) {
            for (int k = j + 1; k < n; k++) {
                if (nums[i] + nums[j] > nums[k] &&
                    nums[i] + nums[k] > nums[j] &&
                    nums[j] + nums[k] > nums[i]) {
                    return true;
                }
            }
        }
    }
    return false;
}
```

`Complejidad:` O(n^2) en el peor caso.

---
