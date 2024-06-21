package aed;

import aed.interfaces.Carreras;

/**
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo CarrerasImpl implementa Carreras{
 *    trieCarreras: TrieDiccionario<MateriasImpl>; 
 *   
 *   InvRep(C:CarrerasImpl){
 *      C.trieCarreras != null;     
 *      }
 *   }
 */
public class CarrerasImpl implements Carreras{

    private TrieDiccionario<MateriasImpl> trieCarreras;

    public CarrerasImpl(){
        this.trieCarreras = new TrieDiccionario<>();          // O(1)
    }
    // Complejidad : O(1)


    public void agregarCarrera(String nombreCarrera, MateriasImpl trieMaterias){
        trieCarreras.definir(nombreCarrera,trieMaterias); // O(|nombreCarrera|) pues trieCarreras es de tipo TrieDiccionario
    }
    // Complejidad : O(|nombreCarrera|)



    public MateriasImpl obtenerMateriasCarrera(String nombreCarrera){
        return trieCarreras.obtener(nombreCarrera);        // O(|nombreCarrera|) pues trieCarreras es de tipo TrieDiccionario
    }
    // Complejidad : O(|nombreCarrera|)



    public String[] obtenerListaDeCarreras(){
        return trieCarreras.obtenerElems();              // O(suma de las longitudes de las carreras)
    }
    // Complejidad : O(suma de las longitudes de las carreras) pues trieCarreras es de tipo TrieDiccionario

    public boolean estaRegistrada(String nombreCarrera){
        return this.trieCarreras.esta(nombreCarrera);    // O(|nombreCarrera|) pues trieCarreras es de tipo TrieDiccionario
    }
    // Complejidad : O(|nombreCarrera|)
}
