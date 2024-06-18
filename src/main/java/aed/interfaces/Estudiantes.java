package aed.interfaces;

public interface Estudiantes {
    /**
     * Registra el ingreso de un/a nuevo/a estudiante al sistema de la universidad e inicializa su cantidad de materias inscriptas en 0.
     * Complejidades:
     *  -EstudiantesImpl: O(long(e)) = O(1) porque long(e) es acotada, donde e es la LU de el/la estudiante a registrar.
     */
    public void registrarEnelSistema(String lu);
    
    /**
     * Amenta la cantidad de materias inscriptas de el/la estudiante en 1.
     * Complejidades:
     *  -EstdiantesImpl: O(long(e)) = O(1) porque long(e) es acotada, donde e es la LU de el/la estudiante a inscribir.
     */
    public void inscribirAMateria(String lu);
    
    /**
     * Devuelve la cantidad de materias en las que esta inscripto/a un/a estudiante.
     * Complejidades:
     *  -EstdiantesImpl: O(long(e)) = O(1) porque long(e) es acotada, donde e es la LU de el/la estudiante al cual se refiere.
     */
    public int cantMateriasInscriptas(String lu);
    /**
     * Reduce la cantidad de materias inscriptas de el/la estudiante en 1.
     * Complejidades:
     *  -EstdiantesImpl: O(long(e)) = O(1) porque long(e) es acotada, donde e es la LU de el/la estudiante a desinscribir.
     */
    public void desinscribir(String lu);   
}
