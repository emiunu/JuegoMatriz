# Juego en una matriz
**Descripción general**

En este ejercicio, se debe crear un juego en Java utilizando una matriz como mapa. Se
debe crear un personaje que se desplazará por la matriz, enfrentará enemigos, recolectará
cofres y deberá intentar llegar a un destino. El personaje y los enemigos estarán
representados mediante arreglos.

Se deberá implementar manejo de errores y pruebas unitarias para asegurar el correcto
funcionamiento de los métodos, por lo que las solicitudes al usuario deben ser externas a
los métodos para poder testearlos correctamente.

**Requisitos**

1. ***Mapa del juego***:

   ○ El mapa será una matriz bidimensional de Strings de largo 10x10 donde
   cada valor representará un elemento del entorno. Se debe representar cada
   elemento con los siguientes símbolos:

   ■ .: Casilla vacía.

   ■ #: Obstáculo que no puede ser atravesado.

   ■ E: Enemigos que el personaje debe enfrentar en combate.

   ■ C: Cofres que contienen recompensas o trampas.

   ■ P: Personaje controlado por el jugador.

   ■ X: Destino o casilla objetivo para ganar el juego.

   
2. ***Personaje***:

   ○ El personaje será representado por un array que almacene:

   ■ Coordenadas X e Y dentro del mapa. (inicialmente la posición de
   inicio de la matriz).

   ■ Vida (inicialmente 100 puntos).

   ■ Ataque (inicialmente 15 puntos).

3. ***Enemigos***:

   ○ Los enemigos serán representados por un array que almacene:

   ■ Coordenadas X e Y dentro del mapa.

   ■ Vida (inicialmente 45 puntos).

   ■ Ataque (inicialmente 10).

4. ***Movimiento del personaje***:

   ○ El jugador deberá ingresar comandos (w, a, s, d) para mover al personaje por
   el mapa.

   ○ El personaje no podrá atravesar obstáculos (#).

   ○ Si el personaje se encuentra con un enemigo (E), deberá iniciar un combate.

   ○ Si el personaje llega a un cofre (C), se disparará un evento aleatorio con un
   50% de probabilidad de que sea una trampa o una recompensa.

5. ***Combate con enemigos***:

   ○ Al encontrarse con un enemigo, el jugador deberá entrar en un menú de
   combate donde tendrá las opciones de:

   ■ Atacar al enemigo.

   ■ Intentar huir del combate.

   ○ Los enemigos también atacarán durante el combate.

   ○ El jugador pierde si su vida llega a 0.

   ○ Si el enemigo es derrotado, se debe eliminar del mapa.

6. ***Cofres con eventos aleatorios***:

   ○ Al encontrar un cofre, el jugador tendrá la opción de abrirlo o no.

   ○ Si lo abre, habrá un 50% de probabilidad de que sea una trampa y pierda
   vida, o de que reciba una recompensa que le otorgue puntos de vida
   adicionales.

7. ***Finalización del juego***:

   ○ El juego finalizará si:

   ■ El jugador alcanza la casilla destino (X).

   ■ El jugador pierde toda su vida.

   *Funcionalidades*

   ● Métodos para generar e imprimir el mapa con los símbolos adecuados para
   representar cada elemento.

   ● Métodos para la creación del Personaje y enemigos.

   ● Métodos para mover al personaje por el mapa, respetando las reglas del terreno
   (no atravesar obstáculos).

   ● Métodos para verificar la posición actual y comprobar si es necesario activar
   un evento.

   ● Métodos de combate que permitan luchar contra enemigos, considerando tanto el
   ataque del personaje como el contraataque del enemigo.

   ● Métodos de manejo de cofres que incluya una lógica de eventos aleatorios.

   ● Métodos para verificar si se gana o pierde.

   Estas funcionalidades son generales y deberán ser desglosadas y desarrolladas en varios
   métodos según se considere conveniente para cumplir con los requisitos del juego.
