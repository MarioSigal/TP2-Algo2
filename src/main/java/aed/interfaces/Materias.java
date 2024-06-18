package aed.interfaces;

import aed.DataMateria;

public interface Materias {
   /**
     * Crea una nueva materia con su informacion correspondiente.
     * Complejidades:
     *  -MateriasImpl: O(long(m)), donde m es la materia a agregar.
     */
    public void agregarMateria(String nombreMateria, DataMateria data);
    
    /**
     * Devuelve la informacion correspondiente a una materia.
     * Complejidades:
     *  -MateriasImpl: O(long(m)), donde m es la materia de la cual se obtiene la informacion.
     */
    public DataMateria obtenerMateria(String nombreMateria);
    
    /**
     * Devuelve una String[] con los nombres de las materias existentes en orden lexicografico.
     * Complejidades:
     *  -MateriasImpl:O(sum_{meM}{long(m)}), donde M es el conjunto de Materias registradas.
     */
    public String[] obtenerListaDeMaterias();
}
