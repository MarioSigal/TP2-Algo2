package aed.interfaces;


public interface Secuencia<T> {

    /**
     * Devuelve el largo de la secuencia.
     * 
     */
    public int longitud();


    /**
     * Agrega un elemento al final de la secuencia.
     * 
     */
    public void agregarAtras(T elem);
    

}