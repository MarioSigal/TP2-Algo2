package aed;
import aed.interfaces.Secuencia;
import aed.interfaces.Iterador;

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private Nodo primero;
    private int longitud;  
    private Nodo ultimo; 

    private class Nodo { 
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

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem); 
        if(ultimo != null){
            ultimo.sig = nuevoNodo; 
        }
        else{
            primero = nuevoNodo; 
        }
        ultimo = nuevoNodo; 
        longitud = longitud + 1; 

    }
    

    private class ListaIterador implements Iterador<T> {
    	
        private int indice; 
        private Nodo nodo;
        
        public ListaIterador(){
            indice = 0; 
            nodo = primero;
        }

        public boolean haySiguiente() {
            return indice != longitud; 
        }

        public T siguiente() {
	        indice += 1; 
            T valor = nodo.valor;
            if(nodo.sig != null){
                nodo = nodo.sig; 
            }
            return valor; 
        }
        
    }

    public Iterador<T> iterador() {
	    return new ListaIterador();
    }

}
