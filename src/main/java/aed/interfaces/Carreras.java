package aed.interfaces;

import aed.MateriasImpl;

public interface Carreras{
    /**
     * Crea una nueva carrera asignandole sus materias.
     * 
     */
    public void agregarCarrera(String nombreCarrera, MateriasImpl trieMaterias);
    
    /**
     * Devuelve el diccionario de materias de una carrera.
     *
     */
    public Materias obtenerMateriasCarrera(String nombreCarrera);
    
    /**
     * Devuelve una String[] con los nombres de las carreras existentes en orden lexicografico.
     * 
     */
    public String[] obtenerListaDeCarreras();
    /**s
     * Devuelve si la Carrera se encuentra definida.
     * 
     */
    public boolean estaRegistrada(String nombreCarrera);
}
