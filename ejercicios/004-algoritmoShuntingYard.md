# Algoritmo de Shunting Yard

Para complementar [la calculadora](https://github.com/mmasias/24-25-PRG2/blob/main/src/calculadora/README.md) que hemos hecho con los alumnos de Programación II, usaremos el algoritmos de [ShuntingYard@Wikipedia](https://es.wikipedia.org/wiki/Algoritmo_shunting_yard)

```
FUNCIÓN shuntingYard(expresiónInfija):
    pila = []
    salida = []
    PARA cada token EN expresiónInfija HACER:
        SI token ES un número ENTONCES:
            AÑADIR token A salida
        SI token ES un operador ENTONCES:
            MIENTRAS pila NO esté vacía Y el tope de pila sea un operador Y la precedencia del tope de pila >= precedencia de token) HACER:
                AÑADIR el tope de pila A salida
                SACAR el tope de pila
            FIN MIENTRAS
            AÑADIR token A pila
        SI token ES '(' ENTONCES:
            AÑADIR token A pila
        SI token ES ')' ENTONCES:
            MIENTRAS el tope de pila NO sea '(' HACER:
                AÑADIR el tope de pila A salida
                SACAR el tope de pila
            FIN MIENTRAS
            SACAR '(' DE pila
    FIN PARA

    MIENTRAS pila NO esté vacía HACER:
        AÑADIR el tope de pila A salida
        SACAR el tope de pila
    FIN MIENTRAS

    DEVOLVER salida
FIN FUNCIÓN
```

## Otra explicación

For each token in turn in the input infix expression:

- If the token is an operand, append it to the postfix output.
- If the token is an operator A then:
  - While there is an operator B of higher or equal precidence than A at the top of the stack, pop B off the stack and append it to the output.
  - Push A onto the stack.
- If the token is an opening bracket, then push it onto the stack.
- If the token is a closing bracket:
  - Pop operators off the stack and append them to the output, until the operator at the top of the stack is a opening bracket.
  - Pop the opening bracket off the stack.

When all the tokens have been read:

- While there are still operator tokens in the stack:
  - Pop the operator on the top of the stack, and append it to the output.
