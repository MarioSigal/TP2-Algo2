package aed.interfaces;

public interface Estudiantes {
    /**
     * Registra el ingreso de un/a nuevo/a estudiante al sistema de la universidad e inicializa su cantidad de materias inscriptas en 0.
     * 
     */
    public void registrarEnelSistema(String lu);
    
    /**
     * Amenta la cantidad de materias inscriptas de el/la estudiante en 1.
     * 
     */
    public void inscribirAMateria(String lu);
    
    /**
     * Devuelve la cantidad de materias en las que esta inscripto/a un/a estudiante.
     * 
     */
    public int cantMateriasInscriptas(String lu);
    /**
     * Reduce la cantidad de materias inscriptas de el/la estudiante en 1.
     * 
     */
    public void desinscribir(String lu);   
}
