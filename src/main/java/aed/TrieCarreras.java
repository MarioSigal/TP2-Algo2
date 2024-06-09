package aed;

import java.lang.reflect.Array;
import java.util.ArrayList;

import aed.interfaces.Carreras;
import aed.interfaces.Materias;
@SuppressWarnings("unused")
public class TrieCarreras implements Carreras{
    //Atributos
    private Nodo raiz;
    private int tamaño; //cantidad de claves
    
    //clase auxiliar
    public class Nodo{
        private Nodo[] hijos;
        private Character valor;
        private String nombre;
        private Materias materias; 
    
        public Nodo() {
            this.hijos = new Nodo[256];
            this.valor = null;
            this.nombre = null;
            this.materias = null;
        }
    }

    //métodos
    public TrieCarreras(){
        this.raiz = new Nodo();
        this.tamaño = 0;
    }

    public void NuevaCarrera(String Nombre){
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()){
            int ascii = (int) c;
            if(nodo.hijos[ascii]==null){
                nodo.hijos[ascii] = new Nodo();
                nodo.hijos[ascii].valor = c;    
            }
            nodo = nodo.hijos[ascii];
        }
        nodo.materias = new Materias();
        nodo.nombre = Nombre;
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

}

