/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4esdras_kathe_camila;

import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author 50488
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase {
    private AdminPalabrasSecretas adminPalabras;

    public JuegoAhorcadoAzar(AdminPalabrasSecretas adminPalabras) {
        super("", "", 10);
        this.adminPalabras = adminPalabras;
        inicializarPalabraSecreta(); // Se asegura de que la palabra nunca sea null
    }

    private String seleccionarPalabraAleatoria() {
        String palabra = adminPalabras.obtenerPalabraAlAzar();
        return (palabra != null) ? palabra : "VACIO"; // Previene errores
    }

    @Override
    public void inicializarPalabraSecreta() {
        PalabraSecretaFija = seleccionarPalabraAleatoria();
        Palabractual = "_".repeat(PalabraSecretaFija.length());
    }

    @Override
    public char actualizarPalabraActual(char letra) {
        StringBuilder nuevaPalabraActual = new StringBuilder(Palabractual);
        boolean encontrada = false;

        for (int i = 0; i < PalabraSecretaFija.length(); i++) {
            if (PalabraSecretaFija.charAt(i) == letra) {
                nuevaPalabraActual.setCharAt(i, letra);
                encontrada = true;
            }
        }

        Palabractual = nuevaPalabraActual.toString();
        return encontrada ? letra : '_';
    }

    @Override
    public boolean verificarLetra(char letra) {
        if (PalabraSecretaFija == null) {
            return false; // Evita error si la palabra no está inicializada
        }
        boolean esCorrecta = PalabraSecretaFija.indexOf(letra) >= 0;
        if (esCorrecta) {
            actualizarPalabraActual(letra);
        } else {
            intentosRestantes--;
        }
        return esCorrecta;
    }

    @Override
    public boolean hasGanado() {
        return Palabractual.equals(PalabraSecretaFija);
    }

    public void jugar() {
        JOptionPane.showMessageDialog(null, "¡HORA DE EMPEZAR!\nAdivina la palabra");

        while (!hasGanado() && intentosRestantes > 0) {
            String letra = JOptionPane.showInputDialog(null, "Palabra: " + Palabractual
                    + "\nIntentos: " + intentosRestantes
                    + "\nIngresa una letra:");

            if (letra == null || letra.isEmpty()) {
                break;
            }

            letra = letra.toUpperCase();
            char letraChar = letra.charAt(0);

            if (verificarLetra(letraChar)) {
                if (hasGanado()) {
                    JOptionPane.showMessageDialog(null, "¡FELICIDADES, GANASTE! La palabra era: " + PalabraSecretaFija);
                }
            } else {
                if (intentosRestantes == 0) {
                    JOptionPane.showMessageDialog(null, "¡UPS, PERDISTE! La palabra era: " + PalabraSecretaFija);
                } else {
                    JOptionPane.showMessageDialog(null, "UPS. Letra incorrecta, intenta de nuevo.");
                }
            }
        }
    }
}
