import java.util.Scanner;

/**
 * JOC 4 - SOPA DE LLETRES
 * Responsable: Adrián Bellido
 * Branca: sopa
 *
 * Trobar 5 paraules amagades en una matriu de lletres de 8x8.
 * Requisits complets: document de requisits, apartat "Joc 4 - Sopa de lletres".
 */
public class SopaLletres {

    public static void jugar() {
        Scanner sc = new Scanner(System.in); // No el tanqueu (sc.close()): tancaria també el del menú

        System.out.println();
        System.out.println("--- SOPA DE LLETRES ---");
        System.out.println("Joc en construcció...");

        char[][] sopa = new char[8][8];
        for (int f = 0; f < 8; f++) {
            for (int c = 0; c < 8; c++) {
                sopa[f][c] = '.';
            }
        }
        String[] paraules = {"latigo","camino","fuente","tiempo","grande"};
        boolean[] trobades= new boolean[5];

        // TODO 1: char[][] sopa (8x8) omplerta de '.'
        // TODO 2: String[] amb 5 paraules (màxim 6 lletres) i boolean[] de trobades
        // TODO 3: col·locar les paraules (primer en posicions fixes, després a l'atzar)
        // TODO 4: omplir les caselles buides amb lletres aleatòries
        // TODO 5: bucle de la partida (fins trobar-les totes)
        //         - mostrar la sopa i la llista de paraules
        //         - llegir i validar la paraula (només lletres, no repetida)
        //         - marcar-la com a trobada (minúscules a la matriu)
        // TODO 6: preguntar "Vols tornar a jugar? (s/n)"
    }
}