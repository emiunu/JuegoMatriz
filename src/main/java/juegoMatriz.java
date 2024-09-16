import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class juegoMatriz {
    public static void main(String[] args) {
        juego();
    }

    public static String [][] mapaJuego(){
        String [][] mapa = new String[10][10];
        mapa[0] = new String[]{"#","#","#","#","#","#","#","#","#","#"};
        mapa[1] = new String[]{"#","P",".",".",".","#","X",".",".","#"};
        mapa[2] = new String[]{"#","#",".",".",".","#",".",".",".","#"};
        mapa[3] = new String[]{"#","C","E",".","#","#","#","#","E","#"};
        mapa[4] = new String[]{"#","#",".",".","#","C",".",".",".","#"};
        mapa[5] = new String[]{"#",".",".",".","#","#",".",".",".","#"};
        mapa[6] = new String[]{"#",".",".",".","#",".",".",".",".","#"};
        mapa[7] = new String[]{"#","C","E",".",".",".",".",".",".","#"};
        mapa[8] = new String[]{"#",".",".",".",".",".",".",".",".","#"};
        mapa[9] = new String[]{"#","#","#","#","#","#","#","#","#","#"};
        return mapa;
    }

    public static void mostrarMapa(String[][] mapa){
        for (int i = 0; i < mapa.length; i++){
            for (int j = 0; j < mapa[i].length; j++){
                System.out.print(" " + mapa[i][j] + " ");
            }
            System.out.println(" ");
        }
    }

    public static int[] iniciarPersonaje(){
        int[] personaje = new int[4];
        personaje[0] = 1;
        personaje[1] = 1;
        personaje[2] = 100;
        personaje[3] = 15;
        return personaje;
    }

    public static int[] enemigo(){
        int [] enemigo = new int[2];
        enemigo[0] = 45;
        enemigo[1] = 10;
        return enemigo;
    }

    public static Scanner scanner(){
        return new Scanner(System.in);
    }

    public static String[] listaLetras(){
        String[] letras = new String[4];
        letras[0] = "w";
        letras[1] = "a";
        letras[2] = "s";
        letras[3] = "d";
        return letras;

    }

    public static String movimientoJugador(){
        String mov = "";
        boolean condicion = true;
        String [] letras = listaLetras();
        while (condicion) {
            mov = scanner().next();
            mov = mov.toLowerCase();
            boolean entradaValida = false;
            for (int i = 0; i < letras.length;i++){
                if (letras[i].equals(mov)){
                    entradaValida = true;
                    condicion = false;
                    break;
                }
            }
            if (!entradaValida){
            System.out.println("Entrada invalida. Intente de nuevo.");
            }
        }
        return mov;
    }

    public static void lecturaMovimiento(String movimiento, int[] jugador, String [][] mapa){
        int nuevaCoordenadaX = jugador[0];
        int nuevaCoordenadaY = jugador[1];
        if (movimiento.equals("w")){
            nuevaCoordenadaY--;
        } else if (movimiento.equals("a")){
            nuevaCoordenadaX--;
        } else if (movimiento.equals("s")){
            nuevaCoordenadaY++;
        } else if(movimiento.equals("d")){
            nuevaCoordenadaX++;
        }
        boolean condicion = verificacionMovimiento(nuevaCoordenadaX, nuevaCoordenadaY,jugador,mapa);
        if (condicion){
            actualizarMapa(mapa,nuevaCoordenadaX,nuevaCoordenadaY,jugador);
        }
    }

    public static boolean verificacionMovimiento(int nuevaCoordenadaX, int nuevaCoordenadaY, int [] jugador, String [][] mapa){
        if (mapa[nuevaCoordenadaY][nuevaCoordenadaX].equals("#")){
            System.out.println("No puedes avanzar, hay un obstáculo.");
            return false;
        } else if (mapa[nuevaCoordenadaY][nuevaCoordenadaX].equals("E")){
            return eventoCombate(jugador);
        }else if (mapa[nuevaCoordenadaY][nuevaCoordenadaX].equals("C")){
            return eventoCofre(jugador);
        } else {
            return true;
        }
    }

    public static void actualizarMapa(String[][] mapa, int nuevaCoordenadaX, int nuevaCoordenadaY, int [] jugador){
        mapa[jugador[1]][jugador[0]] = ".";
        jugador[0] = nuevaCoordenadaX;
        jugador[1] = nuevaCoordenadaY;
        mapa[nuevaCoordenadaY][nuevaCoordenadaX] = "P";
    }

    public static boolean eventoCombate(int[] jugador){
        if (combate(jugador)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean combate(int[] jugador){
        int [] enemigo = enemigo();
        boolean resultadoCombate = true;
        System.out.println("Te has encontrado con un enemigo!!!");
        while (jugador[2]>0 && enemigo[0]>0){
            int opcion = opcionCombate();
            if (opcion == 1 && enemigo[0]>0){
                enemigo[0] -= jugador[3];
                System.out.println("El jugador realiza 15 pts de daño al enemigo");
                if (enemigo[0] > 0){
                    System.out.println("El enemigo realiza 10 pts de daño al jugador");
                    jugador[2] -= enemigo[1];
                } else {
                    System.out.println("Has ganado el combate!!!!");
                    break;
                }
            } else {
                System.out.println("Has huido del combate...");
                resultadoCombate = false;
                break;
            }
        }

        return jugador[2] > 0 && resultadoCombate;
    }


    public static int opcionCombate(){
        int opcion;
        while(true){
            try {
                System.out.println("Que vas a realizar: \n1. Atacar.\n2. Huir.");
                opcion = scanner().nextInt();
                if (opcion == 1 || opcion == 2){
                    break;
                } else {
                    System.out.println("Ingrese un número valido.");
                }
            } catch (InputMismatchException e){
                System.out.println("Ingrese una entrada valida.");
            }
        }
        return opcion;
    }

    public static boolean eventoCofre(int [] jugador){
        if (cofre(jugador)){
            return true;
        } else {
            return false;
        }
    }

    public static boolean cofre(int[] jugador){
        Random condicion = new Random();
        if(condicion.nextBoolean()){
            System.out.println("Has ganado vida!!");
            jugador[2] += 20;
        } else {
            System.out.println("Has perdido vida :(");
            jugador[2] -= 15;
        }
        if (jugador[2] > 0){
            return true;
        } else {
            return false;
        }
    }

    public static boolean continuacionJuego(int[] jugador){
        if (jugador[2] == 0){
            System.out.println("HAS MUERTO");
            return false;
        } else if (jugador[0] == 6 && jugador [1] == 1){
            System.out.println("Felicidades, terminaste el juego!!!");
            return false;
        } else {
            return true;
        }
    }

    public static boolean ejecutarOpcion(){
        int opcion;
        boolean resultadoOpcion;
        while (true){
            try {
                System.out.print("¿Quieres jugar de nuevo? (1. Si/2.No): ");
                opcion = scanner().nextInt();
                if (opcion == 1){
                    resultadoOpcion = true;
                    break;
                } else if (opcion == 2){
                    resultadoOpcion = false;
                    break;
                } else {
                    System.out.println("Ingrese una opcion valida.");
                }
            } catch (InputMismatchException e){
                System.out.println("Ingrese una entrada valida. ");
            }
        }
        return resultadoOpcion;
    }

    public static void statusJugador(int [] jugador){
        System.out.println("Status: ");
        System.out.println("Coordenada X: " + jugador[0] + " | Coordenada Y: " + jugador[1] + " | Vida: " + jugador[2] + " | Ataque: " + jugador[3]);
    }

    public static void juego(){
        boolean juegoIniciado = true;
        while (juegoIniciado){
            String [][] mapa = mapaJuego();
            int [] jugador = iniciarPersonaje();
            boolean continuacionJuego = true;
            while (continuacionJuego) {
                mostrarMapa(mapa);
                statusJugador(jugador);
                lecturaMovimiento(movimientoJugador(), jugador, mapa);
                continuacionJuego = continuacionJuego(jugador);
            }
            juegoIniciado = ejecutarOpcion();
        }

    }


}
