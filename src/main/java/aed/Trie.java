package aed;

import java.util.ArrayList;
@SuppressWarnings("unused")
public class TrieArray<T> {
    private Nodo raiz;
    private int tamaño;
    
    public class Nodo{
        private Nodo[] hijos;
        private Character valor;
        private ArrayList<Object> data ; 
    
        public Nodo() {
            this.hijos = new Nodo[256];
            this.data = new ArrayList<>();;
            this.valor = null;
        }   

        public void addData(Object data) {
            this.data.add(data);
        }
    }

    public TrieArray(){
        this.raiz = new Nodo();
        this.tamaño = 0;
    }

    public void NuevoElem(String Nombre, ArrayList<Object> Data){
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()){
            int ascii = (int) c;
            if(nodo.hijos[ascii]==null){
                nodo.hijos[ascii] = new Nodo();
                nodo.hijos[ascii].valor = c;    
            }
            nodo = nodo.hijos[ascii];
        }
        nodo.data = Data;
        tamaño++;
    }

    public Nodo buscar(String Nombre){
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()){
            int ascii = (int) c;
            if(nodo.hijos[ascii]==null){
                return null;    
            }
            nodo = nodo.hijos[ascii];
        }
        return nodo;
    }

    public ArrayList<Object> getData(String Nombre) {
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()) {
            int ascii = (int) c;
            if (nodo.hijos[ascii] == null) {
                return null;
            }
            nodo = nodo.hijos[ascii];
        }
        return nodo.data;
    }
}
