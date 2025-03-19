# Problema del asensor

El ascensor tiene estos atributos:

Planta en la que se encuentra
Dirección en la que se mueve (arriba, abajo y para)
Lista de personas que están dentro del ascensor
Lista de plantas a las que se tiene que dirigir
Capacidad maxima del ascensor 1 persona

Caso Base :
El ascensor ha llegado a todas las plantas que tenía en su lista de destino.
Si la lista de personas_en_ascensor está vacía y la lista_de_destinos también, el ascensor deja de moverse.

Mi planta actual es igual a mi planta destino 

Caso Recursivo:
El caso recursivo en el método moverAscensorRecursivo(Ascensor ascensor) ocurre cuando el ascensor todavía tiene destinos pendientes y necesita seguir moviéndose hacia ellos.