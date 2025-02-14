/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4esdras_kathe_camila;

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
        return 0;
    
    }

    @Override
    public char verificarLetra(char letra) {
        return 0;
    }

    @Override
    public boolean hasGanado() {
      return true;
    }

    @Override
    public void inicializarPalabraSecreta() {
      
    }

    @Override
    public void jugar() {
    }

   

    
    
}