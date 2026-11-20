import java.util.Scanner;

/**
 * JOC 1 - EL PENJAT
 * Responsable: Alumne A
 * Branca: penjat
 *
 * Endevinar una paraula secreta lletra a lletra abans de cometre 6 errors.
 * Requisits complets: document de requisits, apartat "Joc 1 - El penjat".
 */
public class Penjat {

    public static void jugar() {
        Scanner sc = new Scanner(System.in); // No el tanqueu (sc.close()): tancaria també el del menú

        System.out.println();
        System.out.println("--- EL PENJAT ---");
        System.out.println("Joc en construcció...");

        // TODO 1: array amb almenys 10 paraules i triar-ne una a l'atzar
        // TODO 2: char[] amb el progrés, omplert de '_'
        // TODO 3: bucle de la partida (fins guanyar o arribar a 6 errors)
        //         - llegir i validar la lletra (1 caràcter, lletra, no repetida)
        //         - descobrir-la a TOTES les posicions on aparegui
        //         - mostrar progrés, errors i lletres dites
        // TODO 4: missatge final (guanyat / perdut + paraula)
        // TODO 5: preguntar "Vols tornar a jugar? (s/n)"
    }
}
