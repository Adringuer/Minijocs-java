import java.util.Scanner;

public class Penjat {

    private static final int MAX_ERRORS = 6;

    public static void jugar() {
        Scanner lector = new Scanner(System.in);
        String[] paraules = {
                "ORDINADOR", "PROGRAMA", "TECLAT", "PANTALLA",
                "SERVIDOR", "NAVEGADOR", "DISSENY", "VARIABLE",
                "FITXER", "CADENA", "BUCLE", "CLASSE",
                "RATOLI", "IMPRESSORA", "PROGRAMACIO", "INTERNET",
                "XARXA", "PROCESSADOR", "MEMORIA", "DISC",
                "APLICACIO", "CODI", "ALGORITME", "ROBOT",
                "SISTEMA", "DADES", "BASEDEDADES", "CONTRASENYA",
                "USUARI", "CONNEXIO", "DESCARREGA", "PENJAR",
                "ENLLAC", "CORREU", "MISSATGE", "DOCUMENT",
                "CARPETA", "ICONA", "FINESTRA", "ESCRIPTORI",
                "PROGRAMADOR", "ENGINYER", "TECNOLOGIA", "DIGITAL",
                "SEGURETAT", "VIRUS", "ANTIVIRUS", "NUVOL",
                "XIFRAT", "COMANDA", "TERMINAL", "COMPILADOR",
                "DEPURACIO", "FUNCIO", "METODE", "OBJECTE",
                "HERENCIA", "ATRIBUT", "PARAMETRE", "LLIBRERIA",
                "ACTUALITZACIO", "INTELIGENCIA"
        };

        System.out.println();
        System.out.println("--- EL PENJAT ---");

        boolean tornarAJugar;
        do {
            partida(lector, paraules);
            tornarAJugar = preguntarTornarAJugar(lector);
        } while (tornarAJugar);

        System.out.println("Gràcies per jugar! Tornant al menú...");
    }

    private static void partida(Scanner lector, String[] paraules) {
        int pos = (int) (Math.random() * paraules.length);
        String secreta = paraules[pos];
        char[] progres = new char[secreta.length()];

        for (int i = 0; i < progres.length; i++) {
            progres[i] = '_';
        }

        int errors = 0;
        StringBuilder dites = new StringBuilder();
        boolean guanyat = false;

        while (errors < MAX_ERRORS && !guanyat) {
            mostrarEstat(progres, errors, dites);
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

            if (dites.indexOf(String.valueOf(lletra)) >= 0) {
                System.out.println("Avís: ja has dit aquesta lletra.");
                continue;
            }

            dites.append(lletra).append(' ');
            boolean trobada = false;

            for (int i = 0; i < secreta.length(); i++) {
                if (secreta.charAt(i) == lletra) {
                    progres[i] = lletra;
                    trobada = true;
                }
            }

            if (trobada) {
                System.out.println("Bé! La lletra hi és.");
            } else {
                errors++;
                System.out.println("Ho sento, la lletra no hi és.");
            }

            guanyat = totDescobert(progres);
        }

        if (guanyat) {
            mostrarEstat(progres, errors, dites);
            System.out.println("Enhorabona! Has endevinat la paraula: " + secreta);
        } else {
            System.out.println("Has perdut! La paraula era: " + secreta);
        }
    }

    private static void mostrarEstat(char[] progres, int errors, StringBuilder dites) {
        System.out.println();
        System.out.println("Paraula: " + String.valueOf(progres));
        System.out.println("Errors: " + errors + "/" + MAX_ERRORS);
        System.out.println("Lletres dites: " + dites);
    }

    private static boolean totDescobert(char[] progres) {
        for (char lletra : progres) {
            if (lletra == '_') {
                return false;
            }
        }
        return true;
    }

    private static boolean preguntarTornarAJugar(Scanner lector) {
        while (true) {
            System.out.print("Vols tornar a jugar? (s/n): ");
            String resposta = lector.nextLine().trim();

            if (resposta.equalsIgnoreCase("s")) {
                return true;
            }
            if (resposta.equalsIgnoreCase("n")) {
                return false;
            }

            System.out.println("Avís: respon amb 's' o 'n'.");
        }
    }
}
