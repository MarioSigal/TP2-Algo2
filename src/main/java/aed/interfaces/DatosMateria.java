package aed.interfaces;

import aed.ListaEnlazada;
import aed.MateriasImpl;
import aed.SistemaSIU.CargoDocente;

public interface DatosMateria{
    /**
     * Registra a el/la estudiante en la materia.
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public void agregarAlumno(String lu);
    /**
     * Registra nombres de la materia en otras carreras.
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public void agregarNombre(String nombreMateria);
    
    /**
     * Registra los punteros a la posicion en memoria de los MateriasImpl de otras carreras que tienen una misma materia
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public void agregarTrie(MateriasImpl trieMateria);
    
    /**
     * Devuelve un int[] con el plantel Docente de esta materia [#PROF, #JTP, #AY1, #AY2]
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public int[] obtenerPlantel ();
    
    /**
     * Se agrega a el/la Docente al conteo de su cargo asignado
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public void agregarDocente(CargoDocente cargo);
    
    /**
     * Devuelve la cantidad de estudiantes inscriptos en la materia.
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public int cantInscriptos();
    
    /**
     * Devuelve una lista con las LU de los estudiantes inscriptos en la materia.
     * Complejidad:
     *  -DataMateria:O(1)
     */
    public ListaEnlazada<String> obtenerInscriptos();
    
    /**
     * Borra esta materia en todas las carreras en las que se encuentra disponible.
     * Complejidad:
     *  -DataMateria: O(sum_{neN_{m}}{long(n)})
     */
    public void cerrarMateria();
    
    /**
     * Devuelve si los estdiantes inscriptos exceden o no el cupo
     * Complejidad:
     *  -DataMateria: O(1)
     */
    public boolean excedeCupo();


}