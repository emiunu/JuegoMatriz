import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class juegoMatrizTest {
    String [][] mapa = juegoMatriz.mapaJuego();
    int[] jugador = juegoMatriz.iniciarPersonaje();
    @BeforeEach
    void setUp() {
        mapa = juegoMatriz.mapaJuego();
        jugador = juegoMatriz.iniciarPersonaje();
    }

    @Test
    void verificacionMovimiento(){
        assertTrue(juegoMatriz.verificacionMovimiento(3,1,jugador,mapa));
        assertFalse(juegoMatriz.verificacionMovimiento(0,1,jugador,mapa));

    }

    @Test
    void cofre(){
        assertTrue(juegoMatriz.cofre(jugador));
    }

    @Test
    void continuacionJuego(){
        jugador[2] = 0;
        assertFalse(juegoMatriz.continuacionJuego(jugador));
        jugador[2] = 1;
        jugador[0] = 6;
        jugador[1] = 1;
        assertFalse(juegoMatriz.continuacionJuego(jugador));
        jugador[0] = 2;
        assertTrue(juegoMatriz.continuacionJuego(jugador));
    }
}