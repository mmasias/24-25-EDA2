# **Ejercicio 2: Tripletes suma cero**

`Problema:` Encuentre todos los tripletes que suman cero.

## **Solución (O(n^2))**

Ordenamos el array y usamos dos punteros para encontrar combinaciones.

```java
public static List<List<Integer>> tripletesSumaCero(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> resultado = new ArrayList<>();
    int n = nums.length;
    
    for (int i = 0; i < n - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        int izquierda = i + 1, derecha = n - 1;
        while (izquierda < derecha) {
            int suma = nums[i] + nums[izquierda] + nums[derecha];
            if (suma == 0) {
                resultado.add(Arrays.asList(nums[i], nums[izquierda], nums[derecha]));
                while (izquierda < derecha && nums[izquierda] == nums[izquierda + 1]) izquierda++;
                while (izquierda < derecha && nums[derecha] == nums[derecha - 1]) derecha--;
                izquierda++;
                derecha--;
            } else if (suma < 0) {
                izquierda++;
            } else {
                derecha--;
            }
        }
    }
    return resultado;
}
```

`Complejidad:` O(n^2) debido al doble bucle anidado.

---
