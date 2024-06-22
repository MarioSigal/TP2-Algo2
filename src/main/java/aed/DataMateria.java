package aed;

import aed.SistemaSIU.CargoDocente;
import aed.interfaces.Iterador;
import aed.interfaces.DatosMateria;

/** 
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo DataMateria implementa DatosMateria{
 *    plantelDocente: int[];
 *    inscriptos: ListaEnlazada<String>;
 *    otrosNombres: ListaEnlazada<String>;
 *    otrosTries: ListaEnlazada<MateriasImpl>;
 *   
 * InvRep(D:DataMateria){ 
 *     D.otrosNombres.longitud == D.otrosTrie.longitud &&
 * 
 *     (ParaTodo i:int)( 0<=i< D.otrosNombres.longitud => D.otrosTries[i].esta(D.otrosNombres[i]) )
 *     (Para cada posicion i de otrosNombres debe haber un elemento en la misma
 *      posicion de otrosTries tal que ese nombre este registrado en ese elemento
 *      (de tipo MateriasImpl)) &&
 *     
 *      D.plantelDocente.longitud = 4 && (ParaTodo i:int)(0 <= i < 4 => D.planterDocente[i] >= 0) &&
 *     
 *      (Para todas las posiciones i de otrosNombres, al acceder al elemento en la misma posición de
 *      otrosTries y realizar otrosTries[i].obtenerMateria(otrosNombres[i]) el objeto B devuelto debe
 *      cumplir que B.plantelDocente = D.plantelDocente && B.inscriptos = D.inscriptos && 
 *      B.otrosNombres = D.otrosNombres && B.otrosTries = D.otrosNombres 
 *     }
 *   }
 */
public class DataMateria implements DatosMateria {
  private int[] plantelDocente;
  private ListaEnlazada<String> inscriptos; 
  private ListaEnlazada<String> otrosNombres; 
  private ListaEnlazada<MateriasImpl> otrosTries; 
  
  public DataMateria(){
    this.plantelDocente = new int[4];                     // O(1)
    this.inscriptos = new ListaEnlazada<>();              // O(1)
    this.otrosNombres = new ListaEnlazada<>();            // O(1)
    this.otrosTries = new ListaEnlazada<>();              // O(1)
    for(int i = 0 ; i < 4 ; i++){                         // O(1)
      this.plantelDocente[i] = 0;                         // O(1)
    }
  }
  // Complejidad : O(1)




  public void agregarAlumno(String lu){
    this.inscriptos.agregarAtras(lu);                 // O(1) pues incriptos es una lista enlazada
  }
  // Complejidad : O(1)


  public void agregarNombre(String nombreMateria){
    this.otrosNombres.agregarAtras(nombreMateria);    // O(1) pues otrosNombres es una lista enlazada
  }
  // Complejidad : O(1)
   
  public void agregarTrie(MateriasImpl trieMateria){
    this.otrosTries.agregarAtras(trieMateria);        // O(1) pues otrosNombres es una lista enlazada
  }
  // Complejidad : O(1)

  public int[] obtenerPlantel (){
    return this.plantelDocente;                       // O(1)
    
  }
  // Complejidad : O(1)

  public void agregarDocente(CargoDocente cargo){
    if(cargo == CargoDocente.PROF){                       // O(1)
      this.plantelDocente[0] += 1;                        // O(1)
    }
    else if(cargo == CargoDocente.JTP){                   // O(1)
      this.plantelDocente[1] += 1;                        // O(1)
    }
    else if(cargo == CargoDocente.AY1){                   // O(1)
      this.plantelDocente[2] += 1;                        // O(1)
    }
    else{
      this.plantelDocente[3] += 1;                        // O(1)
    }
  }
  // Complejidad : O(1)

  public int cantInscriptos(){
    return this.inscriptos.longitud();                     // O(1) pues inscriptos es una lista enlazada
  }
  // Complejidad : O(1)

  public ListaEnlazada<String> obtenerInscriptos(){
    return this.inscriptos;                                 // O(1)
  }
  // Complejidad : O(1)

  public void cerrarMateria(){
    Iterador<String> iteradorNombres = this.otrosNombres.iterador();      // O(1)
    Iterador<MateriasImpl> iteradorTries = this.otrosTries.iterador();    // O(1)
    int cantNombresMateria = this.otrosNombres.longitud();                // O(1)
    for(int i = 0 ; i < cantNombresMateria ; i++){
      String nombreMateria = iteradorNombres.siguiente();                 // O(1)
      MateriasImpl trieMateria = iteradorTries.siguiente();               // O(1)
      trieMateria.borrarMateria(nombreMateria);                           // O(|nombreMateria|)
    }
  }

/*La complejidad total es O(suma de las longitudes de los nombres de la materia)
  pues el algoritmo lo que hace, en esencia, es que por cada nombre de la materia
  la va borrando en su respectiva carrera lo cual cuesta O(|nombreMateria|) para 
  cada materia, pues las materias se guardan en un trie. 
*/


  public boolean excedeCupo(){
    int cupo;                                                   // O(1)
    int cupoSegunAY2 = this.plantelDocente[3] * 30;             // O(1)
    int cupoSegunAY1 = this.plantelDocente[2] * 20;             // O(1)  
    int cupoSegunJTP = this.plantelDocente[1] * 100;            // O(1)
    int cupoSegunPROF = this.plantelDocente[0] * 250;           // O(1)

    cupo = min(min(cupoSegunAY2,cupoSegunAY1),min(cupoSegunJTP,cupoSegunPROF)); // O(1)
    
    return (cantInscriptos() > cupo);                                           // O(1)

  }
  // Complejidad : O(1)

  private int min(int num1, int num2){
    if(num1 < num2){                                                // O(1)
      return num1;                                                  // O(1)
    }
    else{                                                           // O(1)
      return num2;                                                  // O(1)
    }
  } 
  // Complejidad : O(1)
}
