package aed;

import aed.interfaces.Carreras;

/**
 * MODULO CON INVARIANTE DE REPRESENTACION:
 *  Modulo CarrerasImpl implementa Carreras{
 *    trieCarreras: TrieDiccionario<MateriasImpl>; 
 *   
 *   InvRep(C:CarrerasImpl){
 *      trieCarreras != null;     
 *      }
 *   }
 */
public class CarrerasImpl implements Carreras{

    private TrieDiccionario<MateriasImpl> trieCarreras;

    public CarrerasImpl(){
        this.trieCarreras = new TrieDiccionario<>();
    }

    public void agregarCarrera(String nombreCarrera, MateriasImpl trieMaterias){
        trieCarreras.definir(nombreCarrera,trieMaterias);
    }

    public MateriasImpl obtenerMateriasCarrera(String nombreCarrera){
        return trieCarreras.obtener(nombreCarrera);
    }

    public String[] obtenerListaDeCarreras(){
        return trieCarreras.obtenerElems();
    }

    public boolean estaRegistrada(String nombreCarrera){
        return this.trieCarreras.esta(nombreCarrera); 
    }
}
