package aed;

import java.util.ArrayList;
import aed.interfaces.Diccionario;
/**
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo Nodo{
 *    hijos: Array<Nodo>;
 *    significado: T;
 *    cantHijos: int;
 *    palabra: String;
 *    
 *   InvRep(n:Nodo){
 *      n.hijos.tamaño = 256 && //hijos: ArrayList<Nodo> de tamaño 256.
 *      (ParaTodo i: int)((0 <= i <= 255) => n.hijos[i] != null <=> i es parte de una palabra)&&
 *      n.cantHijos = sm_{i=0}^{255}{if n.hijos[i]!= null then 1 else 0}
 *      n.significado!=null <=> n.palabra != null &&
 *      n.palabra Debe ser la palabra formada por las letras representadas
 *   por los índices de los nodos anteriores en la cadena de nodos.}
 *      }
 *   }
 *   
 *  Modulo TrieDiccionario<T> implementa Diccionario<T>{
 *    raiz: Nodo;
 *    longitud: int;
 * 
 *   InvRep(T:TrieDiccionario<T>){
 *      longitud >=0
 *      }
 *   }
 */
public class TrieDiccionario<T> implements Diccionario<T>{
  private Nodo raiz;
  private int longitud;

  public class Nodo{
    private ArrayList<Nodo> hijos; 
    private T significado; 
    private int cantHijos; 
    private String palabra; 

    public Nodo(){
      this.hijos = new ArrayList<>(256);          // O(1)
      this.significado = null;                    // O(1)
      this.cantHijos = 0;                         // O(1)
      this.palabra = null;                        // O(1)
      for(int i = 0; i < 255 ; i++){              // O(256) = O(1)
        this.hijos.add(null);                     // O(256) = O(1) pues es un vector pero su longitud maxima es 256
      }
    }
    // Complejidad O(1)

  }

  public TrieDiccionario(){
    this.raiz = new Nodo();              // O(1)
    this.longitud = 0;                   // O(1)             
  }
  // Complejidad : O(1)


  public void definir(String clave,T valor){
    Nodo nodoActual = this.raiz;                            // O(1)
    for (Character c : clave.toCharArray()) {               // O(|clave|) pues se recorre cada caracter
      int ascii = (int) c;                                  // O(1)
      if(nodoActual.hijos.get(ascii) == null){              // O(1) pues se accede a una posicion de un vector
        Nodo nuevoNodo = new Nodo();                        // O(1)
        nodoActual.hijos.set(ascii,nuevoNodo);              // O(1) pues se setea una posicion del vector
        nodoActual.cantHijos += 1;                          // O(1)
      }
      nodoActual = nodoActual.hijos.get(ascii);             // O(1) pues se accede a una posicion de un vector
    }
    if(nodoActual.significado == null){                     // O(1)
      this.longitud += 1;                                   // O(1)
    } 
    nodoActual.significado = valor;                         // O(1)
    nodoActual.palabra = clave;                             //  O(1)
  }

  // Complejidad : O(1) + O(|clave|) * O(1) + O(1) = O(1) + O(|clave|) = O(|clave|)


  public boolean esta(String clave){
    Nodo nodoActual = this.raiz;                          // O(1)
    for (Character c : clave.toCharArray()) {             // O(|clave|)
      int ascii = (int) c;                                // O(1)
      if(nodoActual.hijos.get(ascii) == null){            // O(1)
        return false;                                     // O(1)
      }
      nodoActual = nodoActual.hijos.get(ascii);           // O(1)
    }
    return nodoActual.significado != null;                // O(1)
  }

  // Complejidad : O(1) + O(|clave|) * O(1) + O(1) = O(|clave|)


  public T obtener(String clave){                         
    Nodo nodoActual = this.raiz;                           //  O(1)
    for (Character c : clave.toCharArray()) {              //  O(|clave|)
      int ascii = (int) c;                                 //  O(1)
      nodoActual = nodoActual.hijos.get(ascii);            // O(1)
    }
    return nodoActual.significado;                         // O(1)
  }

  // Complejidad : O(1) + O(|clave|) * O(1) + O(1) = O(|clave|)


  public int longitud(){
    return this.longitud;                                 // O(1)
  }

  // Complejidad : O(1)

  public void borrar(String clave){
    Nodo nodoActual = this.raiz;                              // O(1)
    Nodo ultimoNodoValido = this.raiz;                        // O(1)
    char[] claveArray = clave.toCharArray();                  // O(1)
    int indiceNodoAeliminar = (int) claveArray[0];            // O(1)

    for (int i = 0; i < claveArray.length; i++) {             // O(|clave|)
      
      int ascii = (int) claveArray[i];                        // O(1)
      nodoActual = nodoActual.hijos.get(ascii);               // O(1)

      if((nodoActual.cantHijos > 1 || nodoActual.significado != null) && i!= claveArray.length - 1){
        ultimoNodoValido = nodoActual;
        indiceNodoAeliminar = claveArray[i+1]; 
      } // O(1)

    }

    if(nodoActual.cantHijos > 0){                             // O(1)
      nodoActual.significado = null;                          // O(1)
    }
    else{
      ultimoNodoValido.hijos.set(indiceNodoAeliminar,null);    // O(1)        
      ultimoNodoValido.cantHijos -= 1;                         // O(1) 
    }
    this.longitud -= 1;                                        // O(1) 
  }

  // Complejidad : O(1) + O(|clave|) * O(1) + O(1) = O(|clave|)



  public String[] obtenerElems(){
    ArrayConSig palabras = new ArrayConSig(this.longitud);          // O(1)
    inorder(raiz, palabras);                                        // O(suma de las longitudes de las claves)
    return palabras.devolverArray();                                // O(1)
  }

  public void inorder(Nodo nodo, ArrayConSig array){
    if(nodo.significado != null){                                   // O(1)
      array.agregarElem(nodo.palabra);                              // O(1) (revisar la clase ArrayConsig)
    }
    ArrayList<Nodo> hijos = nodo.hijos;                             // O(1)
    if (nodo.cantHijos > 0) {
      for (int i = 0; i < nodo.hijos.size(); i++) { // recorrer el array nos cuesta O(256) que es O(1).
        
        if(hijos.get(i) != null){                   // O(1)
          inorder(hijos.get(i), array);       
        }
      }
    }
  }

// La complejidad es O(cantNodos) ya que recursivamente se va accediendo a
// cada uno de los nodos no nulos y en cada llamado recursivo se hacen operaciones
// que son O(1).
// Como en el peor caso (cuando las claves no comparten prefijo) 
// cantNodos es igual a la suma de las longitudes de las claves, entonces 
// La complejidad final es O(suma de las longitudes de las claves)


}
