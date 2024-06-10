package aed;

import java.util.ArrayList;
@SuppressWarnings("unused")
public class TrieArrayList<T> {
    private Nodo raiz;
    private int tamaño;
    
    public class Nodo{
        private ArrayList<Nodo> hijos;
        private Character valor;
        private ArrayList<Object> data ; 
    
        public Nodo() {
            this.hijos = new ArrayList<Nodo>(256);
            this.data = null;
            this.valor = null;
        }   
    }

    public TrieArrayList(){
        this.raiz = new Nodo();
        this.tamaño = 0;
    }

    public void NuevoElem(String Nombre, ArrayList<Object> Data){
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()){
            int ascii = (int) c;
            if(nodo.hijos.get(ascii)==null){
                nodo.hijos.set(ascii,new Nodo());
                nodo.hijos.get(ascii).valor = c;    
            }
            nodo = nodo.hijos.get(ascii);
        }
        nodo.data = Data;
        tamaño++;
    }

    public Nodo buscar(String Nombre){
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()){
            int ascii = (int) c;
            if(nodo.hijos.get(ascii)==null){
                return null;    
            }
            nodo = nodo.hijos.get(ascii);
        }
        return nodo;
    }
}
