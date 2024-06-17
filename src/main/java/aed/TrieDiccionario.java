package aed;

import java.util.ArrayList;
import aed.interfaces.Diccionario;

public class TrieDiccionario<T> implements Diccionario<T>{
  private Nodo raiz;
  private int longitud;

  public class Nodo{
    private ArrayList<Nodo> hijos; 
    private T significado; 
    private int cantHijos; 
    private String palabra; 

    public Nodo(){
      this.hijos = new ArrayList<>(256);  
      this.significado = null;
      this.cantHijos = 0;
      this.palabra = null;
      for(int i = 0; i < 255 ; i++){
        this.hijos.add(null); 
      }
    }

  }

  public TrieDiccionario(){
    this.raiz = new Nodo();
    this.longitud = 0;
  }

  public void definir(String clave,T valor){
    Nodo nodoActual = this.raiz;
    for (Character c : clave.toCharArray()) {
      int ascii = (int) c;
      if(nodoActual.hijos.get(ascii) == null){
        Nodo nuevoNodo = new Nodo(); 
        nodoActual.hijos.set(ascii,nuevoNodo); 
        nodoActual.cantHijos += 1; 
      }
      nodoActual = nodoActual.hijos.get(ascii);
    }
    if(nodoActual.significado == null){
      this.longitud += 1; 
    } 
    nodoActual.significado = valor; 
    nodoActual.palabra = clave; 
  }

  public boolean esta(String clave){
    Nodo nodoActual = this.raiz;
    for (Character c : clave.toCharArray()) {
      int ascii = (int) c;
      if(nodoActual.hijos.get(ascii) == null){
        return false;
      }
      nodoActual = nodoActual.hijos.get(ascii);
    }
    return nodoActual.significado != null; 
  }

  public T obtener(String clave){
    Nodo nodoActual = this.raiz;
    for (Character c : clave.toCharArray()) {
      int ascii = (int) c;
      nodoActual = nodoActual.hijos.get(ascii);
    }
    return nodoActual.significado; 
  }


  public int longitud(){
    return this.longitud; 
  }

  public void borrar(String clave){
    Nodo nodoActual = this.raiz;
    Nodo ultimoNodoValido = this.raiz; 
    char[] claveArray = clave.toCharArray();
    int indiceNodoAeliminar = (int) claveArray[0]; 
    for (int i = 0; i < claveArray.length; i++) {
      int ascii = (int) claveArray[i]; 
      nodoActual = nodoActual.hijos.get(ascii); 
      if((nodoActual.cantHijos > 1 || nodoActual.significado != null) && i!= claveArray.length - 1){
        ultimoNodoValido = nodoActual;
        indiceNodoAeliminar = claveArray[i+1]; 
      }

    }
    if(nodoActual.cantHijos > 0){
      nodoActual.significado = null; 
    }
    else{
      ultimoNodoValido.hijos.set(indiceNodoAeliminar,null);
      ultimoNodoValido.cantHijos -= 1; 
    }
    this.longitud -= 1; 
  }

  public String[] obtenerElems(){
    ArrayConSig palabras = new ArrayConSig(this.longitud);
    inorder(raiz, palabras);
    return palabras.devolverArray(); 
  }

  public void inorder(Nodo nodo, ArrayConSig array){
    if(nodo.significado != null){
      array.agregarElem(nodo.palabra);
    }
    ArrayList<Nodo> hijos = nodo.hijos;
    if (nodo.cantHijos > 0) {
      for (int i = 0; i < nodo.hijos.size(); i++) {
        
        if(hijos.get(i) != null){
          inorder(hijos.get(i), array);
        }
      }
    }
  }


}
