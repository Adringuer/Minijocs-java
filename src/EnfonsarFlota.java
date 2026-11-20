import java.util.Scanner;
import java.util.Random;
void main() {
    Scanner sc = new Scanner(System.in);
    String[][] tablero = new String[6][6];
    Random random = new Random();
    random.nextInt(6);

    for (int fila = 0; fila < 5; fila++) {
        for (int columna = 0; columna < 5; columna++) {
            tablero[fila][columna] = ".";
        }
    }
    int quedan = 3;
    for (int i = 1; i <= quedan; i++) {
        int fila = random.nextInt(6);
        int columna = random.nextInt(6);
        tablero[fila][columna] = "B";
    }

    for (int i = 0; i < 40; i++) {
        System.out.println();
    }
    while (quedan > 0) {
        for (int fila = 0; fila < 5; fila++) {
            for (int columna = 0; columna < 5; columna++) {
                if (tablero[fila][columna].equals("B")) {
                    System.out.print(". ");
                } else {
                    System.out.print(tablero[fila][columna] + " ");
                }
            }
            System.out.println();
        }

        System.out.print("Fila (1-5): ");
        int f = sc.nextInt() - 1;
        System.out.print("Columna (1-5): ");
        int c = sc.nextInt() - 1;

        if (tablero[f][c].equals("B")) {
            System.out.println("¡Tocado y hundido!");
            tablero[f][c] = "X";
            quedan--;
        } else {
            System.out.println("Agua");
            tablero[f][c] = "o";
        }
    }

    System.out.println("¡Has ganado!!");
}

