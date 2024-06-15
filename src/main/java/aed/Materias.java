package aed;

public class Materias {
  
  private TrieList<DataMateria> trieMaterias;

  public Materias(){
    this.trieMaterias = new TrieList<>(); 
  }

  public void agregarMateria(String nombreMateria, DataMateria data){
    trieMaterias.definir(nombreMateria, data);
  }

  public DataMateria obtenerMateria(String nombreMateria){
    return trieMaterias.obtener(nombreMateria); 
  }

  public ListaEnlazada<String> obtenerListaDeMaterias(){
    return trieMaterias.obtenerElems(); 
  }
  

}
