package lab4esdras_kathe_camila;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class main extends JFrame {

    private JPanel panel;
    private JPanel panelBotones;
    AdminPalabrasSecretas admin;

    public main() {
        this.setSize(712, 506);
        setTitle("Main");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    public void iniciarComponentes() {
        panel = new JPanel();
        panel.setLayout(null);
        colocarBotones();
        panel.setBackground(Color.WHITE);
        this.getContentPane().add(panel);
    }

    public void colocarBotones() {

        JLabel etiqueta = new JLabel("Menú");
        panel.add(etiqueta);//agregar etiqueta al panel
        etiqueta.setBounds(290, 65, 300, 50);//tamaño y posición de la etiqueta
        etiqueta.setForeground(Color.decode("#f58cce"));//ponerle color a las letras 
        etiqueta.setFont(new Font("Tahoma", Font.BOLD, 36));

        panelBotones = new JPanel();
        panelBotones.setLayout(null);
        panelBotones.setBounds(0, 0, 712, 506);
        panel.add(panelBotones);

        JButton fijo = new JButton("Juego fijo");
        fijo.setBounds(100, 150, 214, 46);
        fijo.setFont(new Font("Tahoma", Font.BOLD, 24));
        fijo.setBackground(Color.decode("#f58cce"));
        panelBotones.add(fijo);

        fijo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Juego fijo seleccionado");
            }
        });

        JButton azar = new JButton("Juego azar");
        azar.setBounds(400, 150, 214, 46);
        azar.setFont(new Font("Tahoma", Font.BOLD, 24));
        azar.setBackground(Color.decode("#f58cce"));
        panelBotones.add(azar);

        azar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Juego azar seleccionado");
                AdminPalabrasSecretas admin = new AdminPalabrasSecretas();
                admin.agregarPalabra("JAVA");
                admin.agregarPalabra("PROGRAMACION");

                JuegoAhorcadoAzar juego = new JuegoAhorcadoAzar(admin);
                juego.jugar();
            }
        });

        JButton agregar = new JButton("Agregar palabra");
        agregar.setBounds(100, 300, 214, 46);
        agregar.setFont(new Font("Tahoma", Font.BOLD, 18));
        agregar.setBackground(Color.decode("#f58cce"));
        panelBotones.add(agregar);

        agregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevaPalabra = JOptionPane.showInputDialog("Ingrese una nueva palabra:");

                if (nuevaPalabra != null && !nuevaPalabra.trim().isEmpty()) {
                    nuevaPalabra = nuevaPalabra.toUpperCase(); // Convertir a mayúsculas para mantener consistencia
                    AdminPalabrasSecretas admin = new AdminPalabrasSecretas();
                    admin.agregarPalabra(nuevaPalabra);

                    System.out.println("Palabra ingresada: " + nuevaPalabra);
                } else {
                    JOptionPane.showMessageDialog(null, "No se agregó una palabra válida.");
                }
            }
        });

        JButton salir = new JButton("salir");
        salir.setBounds(400, 300, 214, 46);
        salir.setFont(new Font("Tahoma", Font.BOLD, 24));
        salir.setBackground(Color.decode("#f58cce"));
        panelBotones.add(salir);

        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    public static void main(String[] args) {
        main m = new main();
        m.setVisible(true);
    }

}
