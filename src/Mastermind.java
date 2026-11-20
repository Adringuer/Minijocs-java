import java.util.Random;
import java.util.Scanner;

public class Mastermind {

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

        String[] secreto = new String[4];

        // Generar combinacion secreta
        for (int i = 0; i < 4; i++) {
            secreto[i] = colores[random.nextInt(colores.length)];
        }

        int maxIntentos = 10;
        boolean ganado = false;

        System.out.println("\n==============================");
        System.out.println("         MASTERMIND");
        System.out.println("==============================");
        System.out.println("Adivina los 4 colores secretos.");
        System.out.println("Colores: ROJO, AZUL, VERDE, AMARILLO, NARANJA, ROSA");
        System.out.println("Tienes 10 intentos.");

        for (int intento = 1; intento <= maxIntentos; intento++) {

            System.out.println("\n--- INTENTO " + intento + " DE " + maxIntentos + " ---");

            String[] respuesta = new String[4];

            for (int i = 0; i < 4; i++) {

                System.out.print("Introduce el color " + (i + 1) + ": ");
                String entrada = teclado.next().toUpperCase();

                while (!contieneColor(colores, entrada)) {
                    System.out.println("Color no valido.");
                    System.out.print("Introduce otro color: ");
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

            // Comprobar colores en posiciones incorrectas
            for (int i = 0; i < 4; i++) {

                if (!respuestaUsada[i]) {

                    for (int j = 0; j < 4; j++) {

                        if (!secretoUsado[j] && respuesta[i].equals(secreto[j])) {
                            blancas++;
                            secretoUsado[j] = true;
                            break;
                        }
                    }
                }
            }

            System.out.println("\nRESULTADO:");
            System.out.println("Rojas: " + rojas);
            System.out.println("Blancas: " + blancas);

            if (rojas == 4) {
                ganado = true;
                break;
            }
        }

        if (ganado) {
            System.out.println("\n¡HAS GANADO!");
        } else {
            System.out.println("\nHAS PERDIDO.");
            System.out.print("La combinacion secreta era: ");

            for (String color : secreto) {
                System.out.print(color + " ");
            }

            System.out.println();
        }

        System.out.println("\nFin de la partida.");
    }

    private static boolean contieneColor(String[] colores, String buscado) {

        for (String color : colores) {
            if (color.equals(buscado)) {
                return true;
            }
        }

        return false;
    }
}