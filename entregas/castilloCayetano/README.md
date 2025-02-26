# Algoritmos Reto003

[__Ejercicios__](https://github.com/mmasias/24-25-EDA2/blob/1b0c9c0182dc8e1a65db42b5f5915dd23eaa9803/ejercicios/003-algoritmos.md)

## Diagrama de Clases

Representacion de las clases del programa.

![Diagrama de Clases](/entregas/castilloCayetano/Images/DdC-Algoritmos.svg)


## [TriangulosPosibles](/entregas/castilloCayetano/src/TriangulosPosibles.java)

Un triangulo esta formado por 3 aristas, y han de ser x < y < z.

```java
 public static boolean encontrarTriangulo(int[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 0; i < array.length - 2; i++) {
            for (int j = i + 1; j < array.length - 1; j++) {
                for (int k = j + 1; k < array.length; k++) {
                    if (array[i] + array[j] > array[k] && array[i] + array[k] > array[j] && array[j] + array[k] > array[i]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
```
