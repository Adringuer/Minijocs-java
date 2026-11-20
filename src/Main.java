import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {

            System.out.println("\n================================");
            System.out.println("          MINI JOCS");
            System.out.println("================================");
            System.out.println("       SELECCIONA UN JUEGO");
            System.out.println();
            System.out.println("  1. El Ahorcado");
            System.out.println("  2. Sopa de letras");
            System.out.println("  3. Mr. Mime");
            System.out.println("  4. Hundir la flota");
            System.out.println("  0. Salir");
            System.out.println("================================");
            System.out.print("Selecciona una opcion: ");

            while (!teclado.hasNextInt()) {
                System.out.println("Introduce un numero valido.");
                teclado.next();
                System.out.print("Selecciona una opcion: ");
            }

            opcion = teclado.nextInt();

            switch (opcion) {

                case 1:
                    teclado.nextLine();
                    Penjat.lectorCompartit = teclado;
                    Penjat.main(args);
                    Penjat.lectorCompartit = null;
                    break;

                case 2:
                    System.out.println("Abriendo Sopa de letras...");
                    break;

                case 3:
                    System.out.println("Abriendo Mr. Mime...");
                    break;

                case 4:
                    System.out.println("Abriendo Hundir la flota...");
                    break;

                case 0:
                    System.out.println("Gracias por jugar. ¡Hasta pronto!");
                    break;

                default:
                    System.out.println("Opcion incorrecta.");
            }

        } while (opcion != 0);

        teclado.close();
    }
}