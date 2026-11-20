
import javax.swing.*;
import java.awt.*;

public class Menu {

    private JFrame ventana;

    public void mostrar() {

        ventana = new JFrame("MINI GAMES");
        ventana.setSize(800, 600);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLocationRelativeTo(null);
        ventana.setResizable(false);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(18, 25, 40));
        panel.setLayout(null);

        JLabel titulo = new JLabel("MINI GAMES");
        titulo.setBounds(0, 40, 800, 70);
        titulo.setForeground(Color.WHITE);
        titulo.setFont(new Font("Arial", Font.BOLD, 45));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitulo = new JLabel("SELECCIONA TU JUEGO");
        subtitulo.setBounds(0, 115, 800, 30);
        subtitulo.setForeground(Color.LIGHT_GRAY);
        subtitulo.setFont(new Font("Arial", Font.PLAIN, 18));
        subtitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JButton ahorcado = crearBoton("EL AHORCADO", 150, 200);
        JButton sopa = crearBoton("SOPA DE LETRAS", 420, 200);
        JButton mrMime = crearBoton("MR. MIME", 150, 320);
        JButton flota = crearBoton("HUNDIR LA FLOTA", 420, 320);
        JButton salir = crearBoton("SALIR", 285, 450);

        ahorcado.addActionListener(e ->
                JOptionPane.showMessageDialog(ventana, "Juego del Ahorcado"));

        sopa.addActionListener(e ->
                JOptionPane.showMessageDialog(ventana, "Juego Sopa de Letras"));

        mrMime.addActionListener(e ->
                JOptionPane.showMessageDialog(ventana, "Juego Mr. Mime"));

        flota.addActionListener(e ->
                JOptionPane.showMessageDialog(ventana, "Juego Hundir la Flota"));

        salir.addActionListener(e -> System.exit(0));

        panel.add(titulo);
        panel.add(subtitulo);
        panel.add(ahorcado);
        panel.add(sopa);
        panel.add(mrMime);
        panel.add(flota);
        panel.add(salir);

        ventana.add(panel);
        ventana.setVisible(true);
    }

    private JButton crearBoton(String texto, int x, int y) {

        JButton boton = new JButton(texto);

        boton.setBounds(x, y, 230, 75);
        boton.setBackground(new Color(40, 90, 150));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("Arial", Font.BOLD, 17));
        boton.setFocusPainted(false);
        boton.setBorderPainted(false);
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));

        return boton;
    }
}