package aed;

import java.util.List;

import aed.TrieCarreras.Nodo;
import aed.interfaces.Materias;

public class TrieMaterias implements Materias{
    //Atributos
    private Nodo raiz;
    private int tamaño; //cantidad de claves
    
    //Clase auxiliar
    public class Nodo{
        private Nodo[] hijos;
        private Character valor;
        private String nombre;
        private int[] docentes;
        private ListaEnlazada estudiantes;
        private int inscriptos;
        private TrieOtrosNombres otrosNombres;
    
        public Nodo() {
            this.hijos = new Nodo[256];
            this.valor = null;
            this.nombre = null;
            this.docentes = null;
            this.estudiantes = null;
            this.inscriptos = 0;
            this.otrosNombres = null;
        }
    }

    //Métodos
    public TrieMaterias(){
        this.raiz = new Nodo();
        this.tamaño = 0;
    }

    public void NuevaMateria(String Nombre){
        Nodo nodo = raiz;
        for (Character c : Nombre.toCharArray()){
            int ascii = (int) c;
            if(nodo.hijos[ascii]==null){
                nodo.hijos[ascii] = new Nodo();
                nodo.hijos[ascii].valor = c;    
            }
            nodo = nodo.hijos[ascii];
        }
        nodo.nombre = Nombre;
        nodo.docentes = new int[4];
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
