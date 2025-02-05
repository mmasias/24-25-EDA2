# Uso de la estructura de Cola en el proyecto


## Introducción

En este proyecto se ha implementado una estructura de datos tipo cola para gestionar la generación y visualización de los frames en la simulación gráfica. La cola es una estructura FIFO (First In, First Out), lo que permite procesar los frames en el orden en que se generan.

## Justificación del uso de Cola

### El uso de una cola es fundamental en este contexto porque:

1 - Gestión ordenada de frames: La Grafica genera nuevos frames de manera periódica y los almacena en la Cola. Luego, la Pantalla extrae los frames en el mismo orden en que fueron insertados.

2 - Evita pérdida de frames: Con esta estructura, se asegura que los frames más antiguos se procesen antes de los nuevos, evitando sobrescrituras o pérdida de datos.

## Problemas identificados

Se han detectado algunos problemas en el código como:

1.  Uso incorrecto de `NodoFrame` en la cola: El método setSiguiente() no recibe correctamente un parámetro de tipo `NodoFrame`, lo que impide la correcta actualización de referencias en la estructura de la cola.

2. Este diseño estaba basado en la idea de que la `Grafica` generaba frames y los almacenaba en su `Cola` a la vez que la `Pantalla` comprueba constantemente la `Cola` de frames que genera esta `Grafica`, y, si hay dos frames como mínimo, se eliminan de esta, se guardan en un buffer que almacena la `Pantalla` y se usan para mostrarlos. Este planteamiento evidentemente sugiere la existencia de dos hilos de ejecución concurrentes, lo cual no se ha visto en clase pero en su momento no me percaté.

3. Posible crecimiento indefinido de la cola: Si la generación de frames es más rápida que su consumo, la memoria puede llenarse sin control.
