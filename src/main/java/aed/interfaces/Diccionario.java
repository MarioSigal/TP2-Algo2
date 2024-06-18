package aed.interfaces;


public interface Diccionario<T>{

    /**
     * Define una nueva calve, con su valor asignado.
     * Complejidades:
     *  -TrieDiccionario: O(L), donde L es la longitud de la clave a definir.
     */
    public void definir(String clave,T valor);
    
    /**
     * Devuelve si la clave se encuentra definida.
     * Complejidades:
     *  -TrieDiccionario: O(L), donde L es la longitud de la clave a buscar.
     */
    public boolean esta(String clave);
    
    /**
     * Devuelve el valor de una clave.
     * Complejidades:
     *  -TrieDiccionario: O(L), donde L es la longitud de la clave a obtener. 
     */
    public T obtener(String clave);
    
    /**
     * Devuelve la cantidad de claves en el diccionario.
     * Complejidades:
     *  -TrieDiccionario: O(1).
     */
    public int longitud();
    
    /**
     * Elimina una clave del diccionario.
     * Complejidades:
     *  -TrieDiccionario: O(L), donde L es la longitud de la clave a eliminar. 
     */
    public void borrar(String clave);
    
    /**
     * Devuelve String[] con las claves del diccionario en orden lexicografico.
     Complejidades:
     *  -TrieDiccionario: O(sum_{keK}{long(k)}), donde K es el conjunto de claves del diccionario.
     */
    public String[] obtenerElems();
} 
