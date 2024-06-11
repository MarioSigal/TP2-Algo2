package aed;

import java.util.ArrayList;

public class Trie<T> {
  private Nodo<T> raiz;
  private int longitud;

  public class Nodo<T>{
    private Nodo<T>[] hijos; 
    private Character clave;
    private T significado; 
    private int cantHijos; 

    public Nodo(){
      this.hijos = new Nodo[256]; 
      this.clave = null; 
      this.significado = null;
      this.cantHijos = 0;
    }

  }

  public Trie(){
    this.raiz = new Nodo<T>();
    this.longitud = 0;
  }

  public void definir(String clave,T valor){
    Nodo<T> nodoActual = this.raiz;
    for (Character c : clave.toCharArray()) {
      int ascii = (int) c;
      if(nodoActual.hijos[ascii] == null){
        Nodo<T> nuevoNodo = new Nodo<T>();
        nuevoNodo.clave = c; 
        nodoActual.hijos[ascii] = nuevoNodo;
        nodoActual.cantHijos += 1; 
      }
      nodoActual = nodoActual.hijos[ascii];
    }
    if(nodoActual.significado == null){
      this.longitud += 1; 
    } 
    nodoActual.significado = valor; 
  }

  public boolean esta(String clave){
    Nodo<T> nodoActual = this.raiz;
    for (Character c : clave.toCharArray()) {
      int ascii = (int) c;
      if(nodoActual.hijos[ascii] == null){
        return false;
      }
      nodoActual = nodoActual.hijos[ascii];
    }
    return nodoActual.significado != null; 
  }

  public T obtener(String clave){
    Nodo<T> nodoActual = this.raiz;
    for (Character c : clave.toCharArray()) {
      int ascii = (int) c;
      nodoActual = nodoActual.hijos[ascii];
    }
    return nodoActual.significado; 
  }


  public int longitud(){
    return this.longitud; 
  }

  public void borrar(String clave){
    Nodo<T> nodoActual = this.raiz;
    Nodo<T> ultimoNodoValido = this.raiz; 
    char[] claveArray = clave.toCharArray();
    int indiceNodoAeliminar = (int) claveArray[0]; 
    for (int i = 0; i < claveArray.length; i++) {
      int ascii = (int) claveArray[i]; 
      nodoActual = nodoActual.hijos[ascii]; 
      if((nodoActual.cantHijos > 1 || nodoActual.significado != null) && i!= claveArray.length - 1){
        ultimoNodoValido = nodoActual;
        indiceNodoAeliminar = claveArray[i+1]; 
      }

    }
