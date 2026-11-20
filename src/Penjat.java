import java.util.Scanner;

public class Penjat {

    private static final int MAX_ERRORS = 6;

    public static void jugar() {

        Scanner lector = new Scanner(System.in);

        System.out.println();
        System.out.println("--- EL PENJAT ---");

        String[] paraules = {
                "ORDINADOR", "PROGRAMA", "TECLAT", "PANTALLA",
                "SERVIDOR", "NAVEGADOR", "DISSENY", "VARIABLE",
                "FITXER", "CADENA", "BUCLE", "CLASSE"
        };

        boolean tornarAJugar;

        do {
           // partida(lector, paraules);
            tornarAJugar = preguntarTornarAJugar(lector);
        } while (tornarAJugar);

        System.out.println("Gràcies per jugar! Tornant al menú...");

        private static void partida(Scanner lector, String[] paraules) {

        }
    }
}