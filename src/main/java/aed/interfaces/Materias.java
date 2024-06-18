package aed.interfaces;

public interface Materias {
    /**
     * Crea una nueva materia con su informacion correspondiente.
     * 
     */
    public void agregarMateria(String nombreMateria, DataMateria data);
    
    /**
     * Devuelve la informacion correspondiente a una materia.
     * 
     */
    public DataMateria obtenerMateria(String nombreMateria);
    
    /**
     * Devuelve una String[] con los nombres de las materias existentes en orden lexicografico.
     * 
     */
    public String[] obtenerListaDeMaterias();
}
