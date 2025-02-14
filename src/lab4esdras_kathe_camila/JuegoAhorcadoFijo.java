/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4esdras_kathe_camila;

import javax.swing.JOptionPane;

/**
 *
 * @author 50488
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
  private String PalabraFija;

    public JuegoAhorcadoFijo(String PalabraFija, int intentosRestantes) {
        super(PalabraFija, "_".repeat(PalabraFija.length()), intentosRestantes);
        this.PalabraFija = PalabraFija;
    }

    public char actualizarPalabraActual(char letra) {
    if (PalabraFija == null) {
        throw new IllegalStateException("Error: PalabraFija no ha sido inicializada.");
    }

    StringBuilder nuevaPalabraActual = new StringBuilder(Palabractual);
    for (int i = 0; i < PalabraFija.length(); i++) {
        if (PalabraFija.charAt(i) == letra) {
            nuevaPalabraActual.setCharAt(i, letra);
        }
    }
    Palabractual = nuevaPalabraActual.toString();
    return letra;
}

@Override
public boolean verificarLetra(char letra) {
    if (PalabraFija == null) {
        throw new IllegalStateException("Error: PalabraFija no ha sido inicializada.");
    }

    boolean PalabraCorrecta = PalabraFija.indexOf(letra) >= 0;
    if (PalabraCorrecta) {
        actualizarPalabraActual(letra);
    } else {
        intentosRestantes--;
    }
    return PalabraCorrecta;
}

@Override
public boolean hasGanado() {
    return Palabractual.equals(PalabraFija);
}

    @Override
    public void jugar() {
        JOptionPane.showMessageDialog(null, "HORA DE EMPEZAR \nAdivine la palabra");
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
                        JOptionPane.showMessageDialog(null, "¡FELICIDADES! Ganaste. La palabra era: " + PalabraSecretaFija);
                    }
                } else {
                    if (intentosRestantes == 0) {
                        JOptionPane.showMessageDialog(null, "¡PERDISTE! La palabra era: " + PalabraSecretaFija);
                    } else {
                        JOptionPane.showMessageDialog(null, "Letra incorrecta, intenta de nuevo.");
                    }
                }
            }
        }
    }

    @Override
   public void inicializarPalabraSecreta() {
        System.out.println("La palabra secreta es: " + PalabraSecretaFija);
    }
}