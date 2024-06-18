package aed.interfaces;

public interface Carreras{
    /**
     * Crea una nueva carrera asignandole sus materias.
     * 
     */
    public void agregarCarrera(String nombreCarrera, Materias trieMaterias);
    
    /**
     * Devuelve el diccionario de materias de una carrera.
     *
     */
    public Materias obtenerCarrera(String nombreCarrera);
    
    /**
     * Devuelve una String[] con los nombres de las carreras existentes en orden lexicografico.
     * 
     */
    public String[] obtenesListaDeCarreras();
    /**s
     * Devuelve si la Carrera se encuentra definida.
     * 
     */
    public boolean estaRegistrada(String nombreCarrera);
}
