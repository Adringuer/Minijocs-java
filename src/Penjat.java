import java.util.Scanner;

public class Penjat {

    public static void main(String[] args) {
        final int MAX_ERRORS = 6;
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
        String[] dibuixos = {
                "  +----------+\n  |          |\n  |          |\n  |          |\n  |          |\n  |          |\n__|__________",
                "  +----------+\n  |          |\n  |          |\n  |          O\n  |          |\n  |          |\n__|__________",
                "  +----------+\n  |          |\n  |          |\n  |          O\n  |          |\n  |          |\n__|__________",
                "  +----------+\n  |          |\n  |          |\n  |          O\n  |         /|\n  |          |\n__|__________",
                "  +----------+\n  |          |\n  |          |\n  |          O\n  |         /|\\\n  |          |\n__|__________",
                "  +----------+\n  |          |\n  |          |\n  |          O\n  |         /|\\\n  |         /\n__|__________",
                "  +----------+\n  |          |\n  |          |\n  |          O\n  |         /|\\\n  |         / \\\n__|__________"
        };

        String respostaTornar;
        do {
            int pos = (int) (Math.random() * paraules.length);
            String secreta = paraules[pos];
            String progres = "";

            for (int i = 0; i < secreta.length(); i++) {
                progres += "_";
            }

            int errors = 0;
            String dites = "";
            boolean guanyat = false;

            while (errors < MAX_ERRORS && !guanyat) {
                System.out.println();
                System.out.println("  ------------------------------------------------");
                System.out.println("  J O C   D E L   P E N J A T");
                System.out.println("  ------------------------------------------------");
                System.out.println();
                System.out.println(dibuixos[errors]);
                System.out.println();
                System.out.println("  PARAULA");
                System.out.print("  ");
                for (int i = 0; i < progres.length(); i++) {
                    System.out.print(progres.charAt(i) + " ");
                }
                System.out.println();
                System.out.println();
                System.out.println("  ERRORS       " + errors + " / " + MAX_ERRORS);
                System.out.println("  LLETRES      " + (dites.isEmpty() ? "-" : dites.trim()));
                System.out.println("  ------------------------------------------------");
                System.out.print("  Escriu una lletra  > ");
                String entrada = lector.nextLine().trim();

                if (entrada.length() != 1) {
                    System.out.println("  Avís: introdueix només una lletra.");
                    continue;
                }

                char lletra = Character.toUpperCase(entrada.charAt(0));
                if (!Character.isLetter(lletra)) {
                    System.out.println("  Avís: el caràcter introduït no és una lletra.");
                    continue;
                }

                if (dites.indexOf(lletra) >= 0) {
                    System.out.println("  Ja havies provat aquesta lletra.");
                    continue;
                }

                dites += lletra + " ";
                boolean trobada = false;

                for (int i = 0; i < secreta.length(); i++) {
                    if (secreta.charAt(i) == lletra) {
                        progres = progres.substring(0, i) + lletra + progres.substring(i + 1);
                        trobada = true;
                    }
                }

                if (trobada) {
                    System.out.println("  Molt bé. La lletra hi és.");
                } else {
                    errors++;
                    System.out.println("  Aquesta lletra no hi és.");
                }

                guanyat = !progres.contains("_");
            }

            if (guanyat) {
                System.out.println("\n  ENHORABONA");
                System.out.println("  Has endevinat la paraula: " + secreta);
            } else {
                System.out.println("\n  PARTIDA ACABADA");
                System.out.println("  La paraula era: " + secreta);
            }

            while (true) {
                System.out.print("\n  Una altra partida? (s/n) > ");
                respostaTornar = lector.nextLine().trim();

                if (respostaTornar.equalsIgnoreCase("s") || respostaTornar.equalsIgnoreCase("n")) {
                    break;
                }

                System.out.println("  Respon amb 's' o 'n'.");
            }
        } while (respostaTornar.equalsIgnoreCase("s"));

        System.out.println("\n  Gràcies per jugar. Fins aviat.");
    }
}
