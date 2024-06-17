package aed;
import aed.interfaces.Materias;



public class Materias implements Materias {
  
  private TrieDiccionario<DataMateria> trieMaterias;

  public Materias(){
    this.trieMaterias = new TrieDiccionario<>(); 
  }

  public void agregarMateria(String nombreMateria, DataMateria data){
    trieMaterias.definir(nombreMateria, data);
  }

  public DataMateria obtenerMateria(String nombreMateria){
    return trieMaterias.obtener(nombreMateria); 
  }

  public String[] obtenerListaDeMaterias(){
    return trieMaterias.obtenerElems(); 
  }
  

}
