package aed;

import aed.interfaces.Carreras;

public class Carreras implements Carreras{

    private TrieDiccionario<Materias> trieCarreras;

    public Carreras(){
        this.trieCarreras = new TrieDiccionaro<>();
    }

    public void agregarCarrera(String nombreCarrera, Materias trieMaterias){
        trieCarreras.definir(nombreCarrera,trieMaterias);
    }

    public Materias obtenerCarrera(String nombreCarrera){
        return trieCarreras.obtener(nombreCarrera);
    }

    public ListaEnlazada<String> obtenesListaDeCarreras(){
        return trieCarreras.obtenerElems();
    }
}