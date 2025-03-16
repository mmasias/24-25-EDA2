## Explicación del código de Notación Polaca Inversa

Imagina que tienes una caja donde puedes poner cosas, pero esa caja tiene una regla especial: solo puedes sacar lo último que pusiste. Esta caja es como una pila (o **stack**), y la regla es "último en entrar, primero en salir". Ahora, vamos a usar esta idea para entender el código que me diste.

### ¿Qué hace este código?

El código tiene un problema de matemáticas donde queremos convertir una **expresión matemática infija** (como `3 + 5`) en una **expresión postfija** (como `3 5 +`), y luego poder evaluarla. En la notación postfija, los números van primero, seguidos de los operadores.

### Función `infijaAPostfijaIterativo`
1. **StringBuilder y Pila**:
   - `StringBuilder salida`: Es como una caja donde vamos guardando los números y operadores que van en la notación postfija.
   - `Stack<Character> pila`: Es otra caja donde guardamos los operadores mientras los procesamos.

2. **Ciclo que recorre cada carácter**:
   - Si es un **número**, lo agregamos directamente a la caja de salida.
   - Si es un **paréntesis izquierdo `(`**, lo metemos en la pila (porque necesitamos saber cuándo termina este paréntesis).
   - Si es un **paréntesis derecho `)`**, sacamos los operadores de la pila y los agregamos a la salida hasta encontrar el paréntesis izquierdo.
   - Si es un **operador (como +, -, *, /)**, lo comparamos con los operadores que están en la pila. Si el operador que estamos viendo tiene menos prioridad que el que está en la pila, sacamos el operador de la pila y lo ponemos en la salida. Luego ponemos el operador actual en la pila.

3. **Al final**:
   - Después de recorrer toda la expresión, sacamos todos los operadores que quedan en la pila y los ponemos en la salida.

### Función `infijaAPostfijaRecursiva`
Este código es básicamente igual que el anterior, pero usa una **función recursiva** en vez de un ciclo. Es como contar historias: en vez de contar la historia paso a paso con un ciclo, la contamos llamando a la misma historia una y otra vez hasta llegar al final.

### Función `evaluarPostfija`
Esta función evalúa una expresión en notación postfija, que es más fácil de resolver que la infija:
1. **Pila de números**: Usamos otra pila, pero esta vez para los números.
2. **Ciclo sobre los caracteres**:
   - Si el carácter es un número, lo agregamos a la pila.
   - Si es un operador, sacamos los dos números más recientes de la pila (que son los últimos que metimos), hacemos la operación con esos números, y metemos el resultado de nuevo en la pila.
3. **Al final**, en la pila solo quedará el resultado final de la operación.

### ¿Cómo usar la pila (Stack)?

Imagina que cada vez que ves algo importante en la expresión, lo pones en la caja (la pila). Cuando tienes que hacer algo con lo que está en la caja (como calcular), sacas lo último que pusiste, haces la operación, y sigues. Esto es lo que hace el código, siempre usando una caja donde solo puedes sacar lo último que pusiste.

Es una forma ordenada de procesar los números y operadores, que hace más fácil resolver las expresiones matemáticas.
