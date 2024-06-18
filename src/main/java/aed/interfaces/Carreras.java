package aed.interfaces;

import aed.MateriasImpl;

public interface Carreras{
    /**
     * Crea una nueva carrera asignandole sus materias.
     * Complejidades:
     *  -CarrerasImpl: O(long(c)), donde c es la carrera a agregar.
     */
    public void agregarCarrera(String nombreCarrera, MateriasImpl trieMaterias);
    
    /**
     * Devuelve diccionario de materias de una carrera.
     * Complejidades:
     *  -CarrerasImpl: O(long(c)), donde c es la carrera a obtener.
     */
    public Materias obtenerMateriasCarrera(String nombreCarrera);
    
    /**
     * Devuelve una String[] con los nombres de las carreras existentes en orden lexicografico.
     * Complejidades:
     *  -CarrerasImpl:O(sum_{ceC}{long(c)}), donde C es el conjunto de Carreras registradas.
     */
    public String[] obtenerListaDeCarreras();
    
    /**
     * Devuelve si la Carrera se encuentra definida.
     * Complejidades:
     *  -CarrerasImpl: O(long(c)), donde c es la carrera a buscar.
     */
    public boolean estaRegistrada(String nombreCarrera);
}
