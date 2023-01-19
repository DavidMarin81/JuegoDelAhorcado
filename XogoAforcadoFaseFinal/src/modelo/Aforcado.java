package modelo;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Clase que implementa unha partida do aforcado
 *
 * @author Profe
 */
public class Aforcado {

    /**
     * Numero maximo de fallos permitidos antes de dar a partida por perdida
     */
    public static final int MAX_ERROS = 6;

    /**
     * Palabra oculta a adivinar na partida
     */
    private PalabraOculta palabraOculta;

    /**
     * Lista cos caracteres fallados na partida
     */
    private final ArrayList<Character> erros = new ArrayList<>();

    /**
     * Crea unha nova partida, indicando a palabra a advidinar
     *
     * @param palabra Palabra a adivinar
     */
    public Aforcado(String palabra) {
        this.palabraOculta = new PalabraOculta(palabra);
    }

    /**
     * Obten a lista de fallos acumulados na partida
     *
     * @return Lista de caracteres fallados acumulados
     */
    public ArrayList<Character> getErros() {
        return erros;
    }

    /**
     * Obten a lista de fallos acumulados na partida en formato String
     *
     * @return String cos caracteres fallados acumulados
     */
    public String getStringErros() {
        String resultado = "";

        for (char c : erros) {
            resultado += c + " ";
        }
        
        return resultado.toUpperCase().trim();
    }

    /**
     * Devolve a palabra oculta pero poñendo un guion nas letras non acertadas
     *
     * @return Palabra oculta coas letras acertadas polo momento
     */
    public String amosarPalabraOculta() {
        return palabraOculta.amosar();
    }

    /**
     * Devolve a palabra oculta mostrando todas as suas letras
     *
     * @return Palabra oculta completa
     */
    public String amosarPalabraCompleta() {
        return palabraOculta.amosarPalabraCompleta();
    }

    /**
     * Proba a ver se o caracter indicado forma parte da palabra oculta. Se
     * esta, marcanse todas as suas aparicions como letras acertadas; se non
     * esta engadese o caracter na lista de fallos acumulados na partida
     *
     * @param c Caracter que se quere comprobar que esta na palabra
     */
    public void comprobarCaracter(char c) {
        if (!palabraOculta.comprobarCaracter(c)) {
            erros.add(c);
        }
    }

    /**
     * Comproba se rematou a partida, ben porque se chegou ao limite de fallos
     * ou ben porque se adiviñou toda a palabra oculta
     *
     * @return true se rematou a partida
     */
    public boolean eFinXogo() {
        return ((maxErrosSuperado()) || palabraOculta.eVisible());
    }

    /**
     * Comproba se se chegou ao limite de fallos permitidos
     *
     * @return true se se chegou ao limite de fallos
     */
    public boolean maxErrosSuperado() {
        return (erros.size() >= Aforcado.MAX_ERROS);
    }
}
