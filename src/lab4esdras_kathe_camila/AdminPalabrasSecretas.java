/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4esdras_kathe_camila;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author 50494
 */
public class AdminPalabrasSecretas {
    public ArrayList <String> palabras = new ArrayList<>();
    
   public AdminPalabrasSecretas() {
        this.palabras = new ArrayList<>();
    }
   
   public void AgregarPalabra(String palabra) {
        if (palabra != null && !palabra.isEmpty()){
            palabras.add(palabra);
          JOptionPane.showMessageDialog(null, "Su palabra ha sido agregada: " + palabra);
        }
   }
         public String ObtenerPalabraAlAzar() {
        if (palabras.isEmpty()){
            JOptionPane.showMessageDialog(null, "No hay palabras disponibles.");
            return null;
        }
        Random ran = new Random();
        String palabra_Seleccionada = palabras.get(ran.nextInt(palabras.size()));
       JOptionPane.showMessageDialog(null, "La palabra que fue seleccionada random es: " + palabra_Seleccionada);
        return palabra_Seleccionada;
    }
        public List<String> getPalabras() {
        return palabras;
    }
   
}