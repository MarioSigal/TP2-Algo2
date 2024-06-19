package aed.interfaces;

import aed.SistemaSIU.CargoDocente;

public interface Sistema {
    
    /**
     * Inscribe al estudiante en la materia de la carrera.
     * Complejidad: O(|c|+ |m|).
     * 
     * @param estudiante
     * @param carrera
     * @param materia
     */
    public void inscribir(String estudiante, String carrera, String materia);

    /**
     * Dada una carrera c y una materia m, devuelve la cantidad de estudiantes inscriptos en la materia, incluyendo a los
estudiantes de todas las carreras.
     * Complejidad: O(|c|+ |m|).
     * 
     * @param materia
     * @param carrera
     * @return Int: Em cantidad de estudiantes inscriptos en la materia m
     */
    public int inscriptos(String materia, String carrera);

    
    /**
     * Agrega a un docente al plantel de la materia m de la carrera c, y al plantel de todas las otras materias que son sus
     equivalentes en el resto de las carreras. 
     * Complejidad: O(|c|+ |m|).
     * 
     * @param cargo
     * @param carrera
     * @param materia
     */
    public void agregarDocente(CargoDocente cargo, String carrera, String materia);

    /**
     * Devuelve un arreglo de enteros donde sus posiciones representan (en orden) la cantidad de profesores, JTPs, AY1 y
AY2, respectivamente, para la materia m dada la carrera c. 
     * Complejidad: O(|c|+ |m|).
     * 
     * @param materia
     * @param carrera
     * @return Arreglo: [#PROF, #JTPs, #AY1, #AY2]
     */
    public int[] plantelDocente(String materia, String carrera);
    
    /**
     * devuelve verdadero si la cantidad de inscriptos en la materia m de la carrera c excede el cupo. 
     * Complejidad: O(|c|+ |m|).
     * 
     * @param materia
     * @param carrera
     * @return Booleano: True si se excede el cupo 
     */
    public boolean excedeCupo(String materia, String carrera);
    
    /**
     * Devuelve el listado de carreras de grado, ordenado lexicográficamente 
     * Complejidad: O(∑_c∈C(|c|)).
     * 
     * @return String: Listado de carreras
     */
    public String[] carreras();
   
    /**
     * Devuelve el listado de materias de una carrera c, ordenado lexicográficamente. 
     * Complejidad: O(|c|+ ∑_mc∈Mc(|mc|)).
     * 
     * @param carrera
     * @return String: Listado de materias de una carrera
     */
    public String[] materias(String carrera);
    /**
     * Devuelve la cantidad de materias en las que se encuentra inscripto/a un/a estudiante. 
     * Complejidad: O(1).
     * 
     * @param estudiante
     * @return Int: Ei cantidad de materias en las que el estudiante esta inscripto
     */
    public int materiasInscriptas(String estudiante);
    
    /**
     * A partir de una carrera c, cierra la materia m para todas las carreras de grado por falta de docentes. 
     * Complejidad: O(|c|+ |m|+ ∑_n∈Nm(|n|)+ Em).
     * 
     * @param materia
     * @param carrera
     */
    public void cerrarMateria(String materia, String carrera);
}
