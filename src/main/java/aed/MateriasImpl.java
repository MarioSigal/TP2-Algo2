package aed;
import aed.interfaces.Materias;



public class MateriasImpl implements Materias {
  
  private TrieDiccionario<DataMateria> trieMaterias;

  public MateriasImpl(){
    this.trieMaterias = new TrieDiccionario<>();              // O(1)
  }
  // Complejidad : O(1)


  public void agregarMateria(String nombreMateria, DataMateria data){
    trieMaterias.definir(nombreMateria, data);                 // O(|nombreMateria|) pues trieMaterias es de tipo TrieDiccionario
  }
  // Complejidad : O(nombreMateria)


  public DataMateria obtenerMateria(String nombreMateria){
    return trieMaterias.obtener(nombreMateria);                 // O(|nombreMateria|) pues trieMaterias es de tipo TrieDiccionario
  }
  // Complejidad : O(nombreMateria)

  public String[] obtenerListaDeMaterias(){
    return trieMaterias.obtenerElems(); 
  }
  // Complejidad : O(suma de las longitudes de las materias) pues trieMaterias es de tipo TrieDiccionario


  public void borrarMateria(String nombreMateria){
    this.trieMaterias.borrar(nombreMateria);
  }
  // Complejidad : O(|nombreMateria|) pues trieMaterias es un TrieDiccionario 

}
