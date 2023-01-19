package modelo;

/**
 * Clase que implemente unha palabra oculta a adiviñar no xogo do aforcado
 * @author Profe
 */
public class PalabraOculta {
    
    /**
     * Array de caracteres da palabra oculta
     */
    private char[] caracteres;
    
    /**
     * Array que indica os caracteres xa acertados
     */
    private boolean[] acertos;
    
    /**
     * Construtor da clase, que recibe o string coa palabra a adiviñar
     * @param string
     */
    public PalabraOculta(String palabra) {
        // Tranformamos o String a un array de caracteres e o almacenamos no atributo
        caracteres = palabra.toCharArray();
        // Inicializamos o array de acertos con tantos elementos como caracteres
        // con todos os valores a falso
        acertos = new boolean[caracteres.length];
        for (int i = 0; i < acertos.length; i++) {
            acertos[i] = false;
        }
    }
    
    /**
     * Comproba se un caracter aparece na lista de caracteres da palabra, marcando
     * todas as aparicions dese caracter como acertadas
     * @param c Caracter a comprobar
     * @return true se o caracter aparece na palabra, false en caso contrario
     */
    public boolean comprobarCaracter(char c) {
        boolean correcto = false;
        
        for (int i = 0; i < caracteres.length; i++) {
            if (caracteres[i] == c) {
                correcto = true;
                acertos[i] = true;
            }
        }
        return correcto;
    }
    
    /**
     * Devolve a palabra substituindo os caracteres non acertados por guions
     * @return Palabra ocultando os caracteres non acertados
     */
    public String amosar() {
        String resultado = "";
        
        for (int i=0; i<caracteres.length; i++) {
            if (acertos[i])
                resultado += " " + caracteres[i] + " ";
            else
                resultado += " _ ";
        }
        
        return resultado.toUpperCase();
    }
    
    /**
     * Devolve a palabra completa, incluindo os caracteres non acertados
     * @return Palabra completa
     */
    public String amosarPalabraCompleta() {
        return new String(caracteres);
    }
    
    /**
     * Indica se a palabra e totalmente visible, e dicir, se todos os caracteres
     * estan xa acertados
     * @return true se todos os caracteres estan acertados, false en caso contrario
     */
    public boolean eVisible() {
        boolean visible = true;
        
        for (boolean acerto : acertos) {
            if (!acerto) {
                visible = false;
            }
        }
        return visible;
    }
}