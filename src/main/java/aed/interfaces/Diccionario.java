package aed.interfaces;


public interface Diccionario<T>{

    /**
     * Define una nueva calve, con su valor asignado.
     * 
     */
    public void definir(String clave,T valor);
    
    /**
     * Devuelve si la clave se encuentra definida.
     * 
     */
    public boolean esta(String clave);
    
    /**
     * Devuelve el valor de una clave.
     * 
     */
    public T obtener(String clave);
    
    /**
     * Devuelve la cantidad de claves en el diccionario.
     * 
     */
    public int longitud();
    
    /**
     * Elimina una clave del diccionario.
     * 
     */
    public void borrar(String clave);
    
    /**
     * Devuelve String[] con las claves del diccionario en orden lexicografico.
     * 
     */
    public String[] obtenerElems();


} 