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
    private static final String[] PALABRAS_POSIBLES = {
        "JAVA", "PROGRAMACION", "ORDENADOR", "LENGUAJE", "VARIABLE", "CLASE", "OBJETO"
    };

    public JuegoAhorcadoAzar() {
        super(seleccionarPalabraAleatoria(), "", 10);
    }

    private static String seleccionarPalabraAleatoria() {
        Random random = new Random();
        return PALABRAS_POSIBLES[random.nextInt(PALABRAS_POSIBLES.length)];
    }

    @Override
    public char actualizarPalabraActual(char letra) {
        String nuevaPalabraActual = "";
        boolean encontrada = false;

        for (int i = 0; i < PalabraSecretaFija.length(); i++) {
            if (PalabraSecretaFija.charAt(i) == letra) {
                nuevaPalabraActual += letra;
                encontrada = true;
            } else {
                nuevaPalabraActual += Palabractual.charAt(i);
            }
        }

        Palabractual = nuevaPalabraActual;
        return encontrada ? letra : '_';
    }

    @Override
    public boolean verificarLetra(char letra) {
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
            } else {
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

   @Override
public void inicializarPalabraSecreta() {
    PalabraSecretaFija = seleccionarPalabraAleatoria(); 
    Palabractual = "_".repeat(PalabraSecretaFija.length());
}
}
