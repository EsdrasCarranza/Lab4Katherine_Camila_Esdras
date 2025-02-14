/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4esdras_kathe_camila;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.JOptionPane;

/**
 *
 * @author 50494
 */
public class AdminPalabrasSecretas {
    private static final String[] PALABRAS_PREDETERMINADAS = {
        "JAVA", "PROGRAMACION", "ORDENADOR", "LENGUAJE", "VARIABLE", "CLASE", "OBJETO"
    };

    private final List<String> palabras;

    public AdminPalabrasSecretas() {
        this.palabras = new ArrayList<>(Arrays.asList(PALABRAS_PREDETERMINADAS));
    }

    public void agregarPalabra(String palabra) {
        if (palabra != null && !palabra.trim().isEmpty()) {
            palabras.add(palabra.toUpperCase());
            JOptionPane.showMessageDialog(null, "Su palabra ha sido agregada: " + palabra.toUpperCase());
        }
    }

    public String obtenerPalabraAlAzar() {
        if (palabras.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay palabras disponibles.");
            return null;
        }
        Random ran = new Random();
        String palabraSeleccionada = palabras.get(ran.nextInt(palabras.size()));
        System.out.println("La palabra seleccionada al azar es: " + palabraSeleccionada);
        return palabraSeleccionada;
    }

    public List<String> getPalabras() {
        return Collections.unmodifiableList(palabras);
    }
}