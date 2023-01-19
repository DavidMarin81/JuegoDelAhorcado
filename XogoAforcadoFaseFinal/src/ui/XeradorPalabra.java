/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 * Interfaz
 *
 * @author Comando G
 */
public interface XeradorPalabra {

    /**
     * Metodo a implementar polas clases que implementen a interfaz
     *
     * @return tipo String
     * @throws XerarPalabraExcepcion pode lanzar unha excepcion
     */
    String xerarPalabra() throws XerarPalabraExcepcion;
     
}
