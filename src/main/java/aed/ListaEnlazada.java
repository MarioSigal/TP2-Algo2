package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private Nodo primero;
    private int longitud;  
    private Nodo ultimo; 

    private class Nodo {
        Nodo ant; 
        T valor;
        Nodo sig; 
        public Nodo (T v){
            valor = v; 
        } 
    }

    public ListaEnlazada() {
        primero = null;
        ultimo = null; 
        longitud = 0; 
    }

    public int longitud() {
        return longitud; 
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem); 
        nuevoNodo.sig = primero;
        if (primero != null){
            primero.ant = nuevoNodo;    
        }
        else{
            ultimo = nuevoNodo; 
        }
        primero = nuevoNodo;
        longitud = longitud + 1; 

    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem); 
        nuevoNodo.ant = ultimo; 
        if(ultimo != null){
            ultimo.sig = nuevoNodo; 
        }
        else{
            primero = nuevoNodo; 
        }
        ultimo = nuevoNodo; 
        longitud = longitud + 1; 

    }
    
    public T obtener(int i) {
        Nodo nodo = primero; 
        for (int j = 0; j < i; j++) {
            nodo = nodo.sig; 
        }
        return nodo.valor; 
    }

    public void eliminar(int i) {
        Nodo nodo = primero; 
        if (i == 0 && longitud == 1){
            primero = null;
            ultimo = null; 
        }
        else if(i == 0){
            Nodo segundo = primero.sig; 
            segundo.ant = null;
            primero = segundo; 
        }
        else if(i == longitud - 1){
            Nodo anteultimo = ultimo.ant;
            anteultimo.sig = null; 
            ultimo = anteultimo; 
        }
        else{
            for (int j = 0; j < i - 1 ; j++) {
                nodo = nodo.sig; 
            }
            Nodo sigNodo = nodo.sig.sig; 
            nodo.sig = sigNodo; 
            sigNodo.ant = nodo; 
        }
        longitud = longitud - 1;
        
        
    }

    public void modificarPosicion(int indice, T elem) {
        Nodo nodo = primero; 
        for (int i = 0; i < indice; i++) {
            nodo = nodo.sig; 
        }
        nodo.valor = elem; 
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> copia = new ListaEnlazada<T>();
        Nodo nodo = primero; 
        for (int i = 0; i < longitud; i++) {
            copia.agregarAtras(nodo.valor); 
            nodo = nodo.sig; 
        }
        return copia; 
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        
        primero = null;
        ultimo = null; 
        longitud = 0; 
        for (int i = 0; i < lista.longitud(); i++) {
            this.agregarAtras(lista.obtener(i)); 
        }
         
    }
    
    @Override
    public String toString() {
        StringBuffer sbuffer = new StringBuffer();
        sbuffer.append("[" + primero.valor.toString() + ",");
        for (int i = 1; i < longitud - 1; i++) {
            sbuffer.append( " " + obtener(i).toString() + ",");
        }
        sbuffer.append( " " + ultimo.valor.toString() + "]");
        return sbuffer.toString(); 
    }

    private class ListaIterador implements Iterador<T> {
    	
        private int indice; 

        public ListaIterador(){
            indice = 0; 
        }

        public boolean haySiguiente() {
            return indice != longitud; 
        }
        
        public boolean hayAnterior() {
	        return indice != 0; 
        }

        public T siguiente() {
	        indice += 1; 
            return obtener(indice-1);
        }
        

        public T anterior() {
	        indice -= 1; 
            return obtener(indice); 
        }
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
