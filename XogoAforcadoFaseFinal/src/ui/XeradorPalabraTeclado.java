/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.Scanner;

/**
 * Clase que implementa o xogo para dous xogadores onde un escribe a palabra a 
 * adiviñar e o outro a adiviña.
 * @author Comando G
 */
public class XeradorPalabraTeclado implements XeradorPalabra {

    /**
     * Metodo que devolve a palabra a adiviñar proposta por un dos xogadores.
     * 
     * @return String coa palabra a adiviñar
     */
    @Override
    public String xerarPalabra(){
        Scanner scan = new Scanner(System.in);
        String palabraTeclado = null;
        System.out.println("Introduzca a palabra a adivi�ar: ");
        if (System.console() != null) {
            palabraTeclado = new String(System.console().readPassword());
        } else {
            try {
                palabraTeclado = new String(System.console().readPassword());
            } catch (Exception e) {
                palabraTeclado = scan.nextLine();
            }
        }
        return palabraTeclado;
    }

}
