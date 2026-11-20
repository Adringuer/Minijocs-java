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

            int pos = (int) (Math.random() * paraules.length);
            String secreta = paraules[pos];

            char[] progres = new char[secreta.length()];

            for (int i = 0; i < progres.length; i++) {
                progres[i] = '_';
            }

            int errors = 0;
            String dites = "";
            boolean guanyat = false;

            while (errors < MAX_ERRORS && !guanyat) {
                mostrarEstat(progres, errors, dites);
            }

            System.out.print("Introdueix una lletra: ");
            String entrada = lector.nextLine().trim();

            if (entrada.length() != 1) {
                System.out.println("Avís: has d'introduir només 1 caràcter.");
                continue;
            }

            char lletra = Character.toUpperCase(entrada.charAt(0));

            if (!Character.isLetter(lletra)) {
                System.out.println("Avís: no és una lletra.");
                continue;
            }

            if (dites.indexOf(lletra) != -1) {
                System.out.println("Avís: ja has dit aquesta lletra.");
                continue;
            }

            dites += lletra + " ";

            boolean trobada = false;

            for (int i = 0; i < secreta.length(); i++) {
                if (secreta.charAt(i) == lletra) {
                    progres[i] = lletra;
                    trobada = true;
                }

                if (trobada) {
                    System.out.println("Bé! La lletra hi és.");
                } else {
                    errors++;
                    System.out.println("Ho sento, la lletra no hi és.");
                }
            }
        }
    }
}