/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4esdras_kathe_camila;

/**
 *
 * @author 50488
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado{
     String PalabraSecreta, Palabractual;
     int intentosRestantes;

    public JuegoAhorcadoBase(String PalabraSecreta, String Palabractual, int intentosRestantes) {
        this.PalabraSecreta = PalabraSecreta;
        this.Palabractual = "_".repeat(PalabraSecreta.length());
        this.intentosRestantes = 10;
    }
    
    public abstract char actualizarPalabraActual(char letra);
    public abstract char verificarLetra(char letra);
    public abstract boolean hasGanado();
    
    
    
}
