import java.util.Scanner;

/**
 * JOC 2 - MASTERMIND
 * Responsable: Alumne B
 * Branca: mastermind
 *
 * Endevinar un codi secret de 4 xifres (de l'1 al 6) en 10 intents,
 * amb pistes d'encerts i mig encerts.
 * Requisits complets: document de requisits, apartat "Joc 2 - Mastermind".
 */
public class Mastermind {

    public static void jugar() {
        Scanner sc = new Scanner(System.in); // No el tanqueu (sc.close()): tancaria també el del menú

        System.out.println();
        System.out.println("--- MASTERMIND ---");
        System.out.println("Joc en construcció...");

        // TODO 1: int[] amb el codi secret (4 xifres entre 1 i 6)
        // TODO 2: bucle de 10 intents
        //         - llegir i validar l'intent (4 caràcters, dígits de l'1 al 6)
        //         - convertir l'String en int[] (charAt(i) - '0')
        //         - comptar encerts i mig encerts (amb boolean[] per marcar)
        //         - guardar i mostrar l'historial d'intents
        // TODO 3: missatge final (guanyat / perdut + codi)
        // TODO 4: preguntar "Vols tornar a jugar? (s/n)"
    }
}
