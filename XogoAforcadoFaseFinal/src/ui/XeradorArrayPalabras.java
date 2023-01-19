package ui;

/**
 * Clase que se encarga de xerar a palabra a adivi�ar
 * Polo momento, simplemente manten unha lista de palabras nun array e escolle
 * unha aleatoriamente
 * @author Profe 
 */
public class XeradorArrayPalabras implements XeradorPalabra{
    
    /**
     * Array coa lista de palabras a adiviñar
     */
    public static final String[] LISTA_PALABRAS = {"programacion", "alumno", "luns", "amigo"};
    
    /**
     * Metodo que xenera a palabra a adiviñar
     * @return Palabra a adiviñar
     */
    @Override
    public String xerarPalabra() {
        int posPalabra = new java.util.Random().nextInt(LISTA_PALABRAS.length);
        return LISTA_PALABRAS[posPalabra];
    }
}
