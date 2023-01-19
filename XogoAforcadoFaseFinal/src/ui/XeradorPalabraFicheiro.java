/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase que selecciona a palabra a adiviñar dun ficheiro
 *
 * @author Comando G
 */
public class XeradorPalabraFicheiro implements XeradorPalabra {
    private String nomeFicheiro = "palabras.txt";
    
    public XeradorPalabraFicheiro() {
        
    }
    
    public XeradorPalabraFicheiro(String ficheiro) {
        this.nomeFicheiro = ficheiro;
    }
    
    public void gardarPalabra(String palabra) throws XerarPalabraExcepcion {
        File ficheiro = new File(this.nomeFicheiro);
        FileWriter escritorFicheiro = null;
        PrintWriter salida = null;
        try {
            if (!ficheiro.exists()) {
                escritorFicheiro = new FileWriter(ficheiro, true);
                salida = new PrintWriter(ficheiro);
                String[] palabrasPorDefecto = XeradorArrayPalabras.LISTA_PALABRAS;
                for (int i = 0; i < palabrasPorDefecto.length; i++) {
                    salida.println(palabrasPorDefecto[i]);
                }
                salida.println(palabra); 
            } else {
                escritorFicheiro = new FileWriter(ficheiro, true);
                salida = new PrintWriter(escritorFicheiro);
                salida.println(palabra); 
            }
            
        } catch (IOException ex) {
            throw new XerarPalabraExcepcion(ficheiro.exists(), "\tERRO!! Non e posible escribir no ficheiro.");
        } finally {
            if (salida != null) {
                salida.close();
            }
            try {
                if (escritorFicheiro != null) {
                    escritorFicheiro.close();
                }
            } catch (IOException ex) {
                throw new XerarPalabraExcepcion(ficheiro.exists(), "\tERRO!! Non é posible pechar o ficheiro.");
            }
        }
    }
    
    /**
     * Metodo para xerar a palabra a partir dun ficheiro
     * 
     * @return a palabra a adiviñar
     * @throws XerarPalabraExcepcion pode xerar unha excepcion relacionada co acceso o ficheiro
     */
    @Override
    public String xerarPalabra() throws XerarPalabraExcepcion {
        Scanner leer = null;
        File ficheiro = new File(this.nomeFicheiro);
        ArrayList<String> listaPalabras = new ArrayList<>();
        String palabra = null;

        try {
            leer = new Scanner(ficheiro);
            while (leer.hasNextLine()) {
                listaPalabras.add(leer.nextLine());
            }
            palabra = listaPalabras.get(new java.util.Random().nextInt(listaPalabras.size()));
        } catch (FileNotFoundException fnfe) {
            throw new XerarPalabraExcepcion(ficheiro.exists(), "\tERRO!! Non e posible atopalo ficheiro coas palabras a adiviñar.");
        } catch (IllegalArgumentException iae) {
            throw new XerarPalabraExcepcion(ficheiro.exists(),
                    "ERRO!! O ficheiro coas palabras a adiviñar está baleiro.");
        } finally {
            if (leer != null) {
                leer.close();
            }
        }
        return palabra;
    }

}
