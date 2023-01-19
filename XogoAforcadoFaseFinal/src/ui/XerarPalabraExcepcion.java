/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

/**
 *
 * @author Comando G
 */
public class XerarPalabraExcepcion extends Exception{
    private boolean visible;

    /**
     *
     * @param bln
     * @param string
     */
    public XerarPalabraExcepcion(boolean visible, String message) {
        super(message);
        this.visible = visible;
    }

    /**
     *
     * @return
     */
    public boolean isVisible() {
        return visible;
    }

    /**
     *
     * @param visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
}
