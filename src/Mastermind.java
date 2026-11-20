import java.util.Random;
import java.util.Scanner;

public class Mastermind {

    // Colores ANSI para la consola
    private static final String RESET = "\u001B[0m";
    private static final String ROJO = "\u001B[31m";
    private static final String AZUL = "\u001B[34m";
    private static final String VERDE = "\u001B[32m";
    private static final String AMARILLO = "\u001B[33m";
    private static final String NARANJA = "\u001B[38;5;208m";
    private static final String ROSA = "\u001B[35m";

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        iniciar(teclado);
    }

    public static void iniciar(Scanner teclado) {

        Random random = new Random();

        String[] colores = {
                "ROJO", "AZUL", "VERDE",
                "AMARILLO", "NARANJA", "ROSA"
        };

        String[] coloresVisuales = {
                ROJO + "ROJO" + RESET,
                AZUL + "AZUL" + RESET,
                VERDE + "VERDE" + RESET,
                AMARILLO + "AMARILLO" + RESET,
                NARANJA + "NARANJA" + RESET,
                ROSA + "ROSA" + RESET
        };

        String[] secreto = new String[4];

        // Generar combinacion secreta
        for (int i = 0; i < 4; i++) {
            secreto[i] = colores[random.nextInt(colores.length)];
        }

        int maxIntentos = 10;
        boolean ganado = false;

        System.out.println("\n==================================");
        System.out.println("          MASTERMIND");
        System.out.println("==================================");
        System.out.println("Descubre la combinacion secreta.");
        System.out.println("\nCOLORES DISPONIBLES:");

        for (String color : coloresVisuales) {
            System.out.print(color + "   ");
        }

        System.out.println("\n\nTienes " + maxIntentos + " intentos.");
        System.out.println("==================================");

        for (int intento = 1; intento <= maxIntentos; intento++) {

            System.out.println("\n---------- INTENTO " + intento + " DE " + maxIntentos + " ----------");

            String[] respuesta = new String[4];

            for (int i = 0; i < 4; i++) {

                System.out.print("Introduce el color " + (i + 1) + ": ");

                String entrada = teclado.next().toUpperCase();

                while (!contieneColor(colores, entrada)) {
                    System.out.println("Color no valido. Intentalo otra vez.");
                    System.out.print("Introduce el color " + (i + 1) + ": ");
                    entrada = teclado.next().toUpperCase();
                }

                respuesta[i] = entrada;
            }

            int rojas = 0;
            int blancas = 0;

            boolean[] secretoUsado = new boolean[4];
            boolean[] respuestaUsada = new boolean[4];

            // Comprobar posiciones correctas
            for (int i = 0; i < 4; i++) {

                if (respuesta[i].equals(secreto[i])) {
                    rojas++;
                    secretoUsado[i] = true;
                    respuestaUsada[i] = true;
                }
            }

            // Comprobar colores correctos en posiciones incorrectas
            for (int i = 0; i < 4; i++) {

                if (!respuestaUsada[i]) {

                    for (int j = 0; j < 4; j++) {

                        if (!secretoUsado[j] &&
                                respuesta[i].equals(secreto[j])) {

                            blancas++;
                            secretoUsado[j] = true;
                            break;
                        }
                    }
                }
            }

            System.out.println("\nTU COMBINACION:");

            for (String color : respuesta) {
                mostrarColor(color);
                System.out.print("   ");
            }

            System.out.println("\n\nPISTAS:");
            System.out.println(ROJO + "ROJAS: " + rojas + RESET);
            System.out.println("BLANCAS: " + blancas);

            if (rojas == 4) {
                ganado = true;
                break;
            }
        }

        // Resultado final
        System.out.println("\n==================================");

        if (ganado) {

            System.out.println(VERDE + "¡HAS GANADO!" + RESET);
            System.out.println("Has descubierto la combinacion.");

        } else {

            System.out.println(ROJO + "¡HAS PERDIDO!" + RESET);
            System.out.print("La combinacion secreta era: ");

            for (String color : secreto) {
                mostrarColor(color);
                System.out.print("   ");
            }

            System.out.println();
        }

        System.out.println("==================================");
        System.out.println("Fin de la partida.");
    }

    // Comprobar si el color existe
    private static boolean contieneColor(String[] colores, String buscado) {

        for (String color : colores) {

            if (color.equals(buscado)) {
                return true;
            }
        }

        return false;
    }

    // Mostrar cada color con su color correspondiente
    private static void mostrarColor(String color) {

        switch (color) {

            case "ROJO":
                System.out.print(ROJO + "ROJO" + RESET);
                break;

            case "AZUL":
                System.out.print(AZUL + "AZUL" + RESET);
                break;

            case "VERDE":
                System.out.print(VERDE + "VERDE" + RESET);
                break;

            case "AMARILLO":
                System.out.print(AMARILLO + "AMARILLO" + RESET);
                break;

            case "NARANJA":
                System.out.print(NARANJA + "NARANJA" + RESET);
                break;

            case "ROSA":
                System.out.print(ROSA + "ROSA" + RESET);
                break;
        }
    }
}