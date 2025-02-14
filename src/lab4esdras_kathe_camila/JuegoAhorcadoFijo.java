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
    String PalabraFija;

    public JuegoAhorcadoFijo(String PalabraFija, String PalabraSecreta, String Palabractual, int intentosRestantes) {
        super(PalabraSecreta, Palabractual, intentosRestantes);
        this.PalabraFija = PalabraFija;
    }

    

    @Override
    public char actualizarPalabraActual(char letra) {
       String nuevaPalabraActual = "";
        for (int i = 0; i < PalabraSecretaFija.length(); i++) {
            if (PalabraSecretaFija.charAt(i) == letra) {
                nuevaPalabraActual += letra; 
            } else {
                nuevaPalabraActual += Palabractual.charAt(i); 
            }
        }
        Palabractual = nuevaPalabraActual;
        return 0;
    }
   
    @Override
    public boolean verificarLetra(char letra) {
    boolean PalabraCorrecta = PalabraSecretaFija.indexOf(letra) >= 0;
        if (PalabraCorrecta) {
            actualizarPalabraActual(letra);
        } else {
            intentosRestantes--;
        }
        return PalabraCorrecta;
    }

    @Override
    public boolean hasGanado() {
     return Palabractual.equals(PalabraSecretaFija);
    }

    @Override
    public void jugar() {
        JOptionPane.showMessageDialog(null, "HORA DE EMPEZAR \nAdivine la palabra");
        while (!hasGanado() && intentosRestantes > 0) {
            String letra=" ";
            letra = JOptionPane.showInputDialog(null, "Palabra: " + Palabractual
                    + "\nIntentos: " + intentosRestantes
                    + "\nIngresa una letra:");
            if (letra == null || letra.isEmpty()) {
                break;
            }else{ 
                letra=letra.toUpperCase();
                char letraChar = letra.charAt(0);
                if (verificarLetra(letraChar)) {
                    actualizarPalabraActual(letraChar);
                    if (hasGanado()) {
                        JOptionPane.showMessageDialog(null, "FELICIDADES USTED GANO! Su palabra era: " + intentosRestantes);
                    }
                } else {
                    if (intentosRestantes == 0) {
                        JOptionPane.showMessageDialog(null, "PERDEDOR! La palabra era: " + intentosRestantes);
                    } else {
                        JOptionPane.showMessageDialog(null, "OH NO, Letra incorrecta, por favor intenta de nuevo.");
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