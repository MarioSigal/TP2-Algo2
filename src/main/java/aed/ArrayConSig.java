package aed;
/**
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo ArrayConSig{
 *    siguiente: int;
 *    array: String[];
 *   InvRep(a:ArrayConSig){
 *     0 <= a.siguiente <= a.array.length
 *     }
 *   }
**/
public class ArrayConSig {
  private String[] array; 
  private int siguiente;

  public ArrayConSig(int capacidad){
    this.array = new String[capacidad];                 // O(1)
    this.siguiente = 0;                                 // O(1)
  }

  // Complejidad O(1)

  public void agregarElem(String elem){
    this.array[siguiente] = elem;                        // O(1) pues se setea la posicion de un array
    this.siguiente += 1;                                 // O(1)
  }

  // Complejidad O(1)

  public String[] devolverArray(){
    return this.array;                                   // O(1)
  }

  // Complejidad O(1)

}
