import java.util.Scanner;

/**
 * JOC 4 - SOPA DE LLETRES
 * Responsable: Adrián Bellido
 * Branca: sopa
 *
 * Trobar 5 paraules amagades en una matriu de lletres de 8x8.
 * Les paraules es triïen a l'atzar d'una llista i es troben amb coordenades.
 * Requisits complets: document de requisits, apartat "Joc 4 - Sopa de lletres".
 */
public class SopaLletres {

    public static void jugar() {
        Scanner sc = new Scanner(System.in);

        System.out.println();
        System.out.println("--- SOPA DE LLETRES ---");

        String[] totes = {
                "JAVA", "CLASSE", "BUCLE", "ARRAY", "CODI", "INT", "CHAR", "BYTE",
                "FLOAT", "LONG", "NULL", "TRUE", "FALSE", "VOID", "FINAL", "SUPER",
                "WHILE", "BREAK", "CASE", "ELSE", "CATCH", "MAIN", "PRINT", "IMPORT",
                "PUBLIC", "STRING", "THIS", "SHORT", "STATIC", "DOUBLE", "SWITCH", "RETURN"
        };

        String tornar;

        do {
            char[][] sopa = new char[8][8];
            for (int f = 0; f < 8; f++) {
                for (int c = 0; c < 8; c++) {
                    sopa[f][c] = '.';
                }
            }

            String[] paraules = new String[5];
            boolean[] triada = new boolean[totes.length];
            for (int i = 0; i < paraules.length; i++) {
                int n = (int) (Math.random() * totes.length);
                while (triada[n]) {
                    n = (int) (Math.random() * totes.length);
                }
                triada[n] = true;
                paraules[i] = totes[n];
            }

            boolean[] trobades = new boolean[5];

            int[] filaInici = new int[5];
            int[] colInici = new int[5];
            int[] direccio = new int[5];

            for (int p = 0; p < paraules.length; p++) {
                int llargada = paraules[p].length();
                boolean colocada = false;

                while (!colocada) {
                    int d = (int) (Math.random() * 2);
                    int f = (int) (Math.random() * 8);
                    int c = (int) (Math.random() * 8);

                    boolean cap = true;
                    if (d == 0 && c + llargada > 8) {
                        cap = false;
                    }
                    if (d == 1 && f + llargada > 8) {
                        cap = false;
                    }

                    if (cap) {
                        for (int k = 0; k < llargada; k++) {
                            int ff = f;
                            int cc = c;
                            if (d == 0) {
                                cc = c + k;
                            } else {
                                ff = f + k;
                            }
                            if (sopa[ff][cc] != '.') {
                                cap = false;
                            }
                        }
                    }
                    if (cap) {
                        for (int k = 0; k < llargada; k++) {
                            int ff = f;
                            int cc = c;
                            if (d == 0) {
                                cc = c + k;
                            } else {
                                ff = f + k;
                            }
                            sopa[ff][cc] = paraules[p].charAt(k);
                        }
                        filaInici[p] = f;
                        colInici[p] = c;
                        direccio[p] = d;
                        colocada = true;
                    }
                }
            }
            for (int f = 0; f < 8; f++) {
                for (int c = 0; c < 8; c++) {
                    if (sopa[f][c] == '.') {
                        sopa[f][c] = (char) ('A' + (int) (Math.random() * 26));
                    }
                }
            }
            int quantesTrobades = 0;

            while (quantesTrobades < paraules.length) {
                mostrarSopa(sopa);

                System.out.println();
                System.out.println("Paraules a trobar:");
                for (int p = 0; p < paraules.length; p++) {
                    if (trobades[p]) {
                        System.out.println("- " + paraules[p] + " (trobada)");
                    } else {
                        System.out.println("- " + paraules[p]);
                    }
                }
                System.out.println();
                System.out.println("Escriu les coordenades de la paraula (de la primera a l'última lletra)");
                System.out.println("Fila d'inici (1-8):");
                int fila1 = llegirEnter(sc);
                System.out.println("Columna d'inici (1-8):");
                int col1 = llegirEnter(sc);
                System.out.println("Fila final (1-8):");
                int fila2 = llegirEnter(sc);
                System.out.println("Columna final (1-8):");
                int col2 = llegirEnter(sc);

                if (fila1 < 1 || fila1 > 8 || col1 < 1 || col1 > 8
                        || fila2 < 1 || fila2 > 8 || col2 < 1 || col2 > 8) {
                    System.out.println("Les coordenades han de ser entre 1 i 8.");
                } else {
                    fila1 = fila1 - 1;
                    col1 = col1 - 1;
                    fila2 = fila2 - 1;
                    col2 = col2 - 1;

                    int posicio = -1;
                    for (int p = 0; p < paraules.length; p++) {
                        int filaFi = filaInici[p];
                        int colFi = colInici[p];
                        if (direccio[p] == 0) {
                            colFi = colFi + paraules[p].length() - 1;
                        } else {
                            filaFi = filaFi + paraules[p].length() - 1;
                        }

                        if (filaInici[p] == fila1 && colInici[p] == col1
                                && filaFi == fila2 && colFi == col2) {
                            posicio = p;
                        }
                    }

                    if (posicio == -1) {
                        System.out.println("Aquí no hi ha cap paraula.");
                    } else if (trobades[posicio]) {
                        System.out.println("Ja has trobat aquesta paraula.");
                    } else {
                        for (int k = 0; k < paraules[posicio].length(); k++) {
                            int ff = filaInici[posicio];
                            int cc = colInici[posicio];
                            if (direccio[posicio] == 0) {
                                cc = cc + k;
                            } else {
                                ff = ff + k;
                            }
                        }
                        trobades[posicio] = true;
                        quantesTrobades++;
                        System.out.println("Molt bé! Has trobat " + paraules[posicio] + ".");
                    }
                }
            }
            mostrarSopa(sopa);
            System.out.println();
            System.out.println("Enhorabona! Has trobat totes les paraules!");

            System.out.println("Vols tornar a jugar? (s/n)");
            tornar = sc.nextLine().trim().toLowerCase();

        } while (tornar.equals("s"));
    }
    private static void mostrarSopa(char[][] sopa) {
        System.out.println();
        System.out.print("  ");
        for (int c = 0; c < 8; c++) {
            System.out.print((c + 1) + " ");
        }
        System.out.println();

        for (int f = 0; f < 8; f++) {
            System.out.print((f + 1) + " ");
            for (int c = 0; c < 8; c++) {
                System.out.print(sopa[f][c] + " ");
            }
            System.out.println();
        }
    }

    private static int llegirEnter(Scanner sc) {
        while (!sc.hasNextInt()) {
            sc.next();
            System.out.println("Has d'escriure un número:");
        }
        return sc.nextInt();
    }
}
        // TODO 1: char[][] sopa (8x8) omplerta de '.'
        // TODO 2: String[] amb 5 paraules (màxim 6 lletres) i boolean[] de trobades
        // TODO 3: col·locar les paraules (primer en posicions fixes, després a l'atzar)
        // TODO 4: omplir les caselles buides amb lletres aleatòries
        // TODO 5: bucle de la partida (fins trobar-les totes)
        //         - mostrar la sopa i la llista de paraules
        //         - llegir i validar la paraula (només lletres, no repetida)
        //         - marcar-la com a trobada (minúscules a la matriu)
        // TODO 6: preguntar "Vols tornar a jugar? (s/n)"

