package aed;
import aed.interfaces.Secuencia;
import aed.interfaces.Iterador;

/* Invariante de representación:
 * - longitud es igual a la cantidad de veces que se puede realizar primero.sig 
 *   hasta obtener un null. 
 * - ultimo es null <=> longitud = 0
 * - si longitud >= 1 entonces ultimo != null
 * - luego de hacer primero.sig (longitud - 1) veces se llega a ultimo. 
 * - No hay bucles, es decir, despues de hacer primero.sig una cantidad finita de
 *   veces se obtiene null. 
 */

public class ListaEnlazada<T> implements Secuencia<T> {
    
    private Nodo primero;
    private int longitud;  
    private Nodo ultimo; 

    private class Nodo { 
        T valor;
        Nodo sig; 

        public Nodo (T v){
            valor = v; // O(1)
        } 

        // Complejidad O(1)
    }

    public ListaEnlazada() {
        primero = null;    // O(1)
        ultimo = null;     // O(1)
        longitud = 0;     // O(1)
    }

    // Complejidad : O(1)


    public int longitud() {
        return longitud; // O(1)
    }

    // Complejidad : O(1)


    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);        // O(1) 
        if(ultimo != null){                     // O(1)
            ultimo.sig = nuevoNodo;             // O(1)
        }
        else{
            primero = nuevoNodo;                // O(1)
        }

        ultimo = nuevoNodo;                     // O(1)
        longitud = longitud + 1;                // O(1)

    }
    
    // Complejidad : O(1)

    private class ListaIterador implements Iterador<T> {
    	
        private int indice; 
        private Nodo nodo;
        
        public ListaIterador(){
            indice = 0;                         // O(1)
            nodo = primero;                     // O(1)
        }
        
        // Complejidad O(1)


        public boolean haySiguiente() {
            return indice != longitud;         // O(1)
        }

        // Complejidad O(1)

        public T siguiente() {
	        indice += 1;                       // O(1)
            T valor = nodo.valor;              // O(1)
            if(nodo.sig != null){              // O(1)
                nodo = nodo.sig;               // O(1)
            }
            return valor; 
        }

        // Complejidad O(1)
        
    }

    public Iterador<T> iterador() {
	    return new ListaIterador(); // O(1)
    }
    // Complejidad O(1)
}
