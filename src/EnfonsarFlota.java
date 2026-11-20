import java.util.Scanner;

/**
 * JOC 3 - ENFONSAR LA FLOTA
 * Responsable: Alumne C
 * Branca: flota
 *
 * Enfonsar 5 vaixells amagats en un tauler de 5x5 amb un màxim de 15 trets.
 * Requisits complets: document de requisits, apartat "Joc 3 - Enfonsar la flota".
 */
public class EnfonsarFlota {

    public static void jugar() {
        Scanner sc = new Scanner(System.in); // No el tanqueu (sc.close()): tancaria també el del menú

        System.out.println();
        System.out.println("--- ENFONSAR LA FLOTA ---");
        System.out.println("Joc en construcció...");

        // TODO 1: boolean[][] vaixells (5x5) i char[][] visible (5x5, omplert de '~')
        // TODO 2: col·locar 5 vaixells a l'atzar sense repetir posició
        // TODO 3: bucle de la partida (fins enfonsar-los tots o gastar 15 trets)
        //         - dibuixar el tauler visible amb les coordenades
        //         - llegir i validar fila i columna (0-4, casella no disparada)
        //         - "Aigua!" (O) o "Tocat i enfonsat!" (X)
        // TODO 4: missatge final (guanyat / perdut + on eren els vaixells)
        // TODO 5: preguntar "Vols tornar a jugar? (s/n)"
    }
}
