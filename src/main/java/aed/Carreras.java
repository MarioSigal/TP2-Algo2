package aed;

import aed.interfaces.Carreras;

public class Carreras implements Carreras{

    private TrieDiccionario<Materias> trieCarreras;

    public Carreras(){
        this.trieCarreras = new TrieDiccionario<>();
    }

    public void agregarCarrera(String nombreCarrera, Materias trieMaterias){
        trieCarreras.definir(nombreCarrera,trieMaterias);
    }

    public Materias obtenerMateriasCarrera(String nombreCarrera){
        return trieCarreras.obtener(nombreCarrera);
    }

    public ListaEnlazada<String> obtenerListaDeCarreras(){
        return trieCarreras.obtenerElems();
    }

    public boolean estaRegistrada(String nombreCarrera){
        return this.trieCarreras.esta(nombreCarrera); 
    }
}