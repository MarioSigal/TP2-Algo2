package aed;

import aed.interfaces.Estudiantes;

/**
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo EstudiantesImpl implementa Estudiantes{
 *    trieEstudiantes: TrieDiccionario<String>; 
 *   InvRep(E:EstudiantesImpl){
 *      E.trieEstudiantes != null     
 *      }
 *   }
 */

public class EstudiantesImpl implements Estudiantes{
  private TrieDiccionario<String> trieEstudiantes;

  public EstudiantesImpl(){
    this.trieEstudiantes = new TrieDiccionario<>();                 // O(1)
  }
  // Complejidad : O(1)


  public void registrarEnelSistema(String lu){
    trieEstudiantes.definir(lu,0);                            // O(|lu|) pues trieEstudiantes es de tipo TrieDiccionario
  }
  // Complejidad : O(|lu|) = O(1) pues |lu| es acotada. 


  public void inscribirAMateria(String lu){
    trieEstudiantes.definir(lu,cantMateriasInscriptas(lu) + 1);   // O(|lu|) + O(|lu|) pues trieEstudiantes es de tipo TrieDiccionario
  }
  // Complejidad : O(|lu|) + O(|lu|) = O(|lu|) = O(1) pues |lu| es acotada. 


  public int cantMateriasInscriptas(String lu){
    return this.trieEstudiantes.obtener(lu);                      // O(|lu|) pues trieEstudiantes es de tipo TrieDiccionario
  }
  // Complejidad : O(|lu|) = O(1) pues |lu| es acotada. 

  
  public void desinscribir(String lu){
    trieEstudiantes.definir(lu, cantMateriasInscriptas(lu) - 1);  // O(|lu|) + O(|lu|) pues trieEstudiantes es de tipo TrieDiccionario
  }
  // Complejidad : O(|lu|) + O(|lu|) = O(|lu|) = O(1) pues |lu| es acotada. 
}
