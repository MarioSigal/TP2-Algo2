package aed;

import aed.interfaces.Sistema;

public class SistemaSIU implements Sistema {
    private Carreras carreras; 
    private Estudiantes estudiantes; 

    public enum CargoDocente{
        AY2,
        AY1,
        JTP,
        PROF
    }

    public SistemaSIU(InfoMateria[] materiasEnCarreras, String[] libretasUniversitarias){
        this.carreras = new Carreras();
        this.estudiantes = new Estudiantes();

        for(String lu : libretasUniversitarias){
            this.estudiantes.registrarEnelSistema(lu); 
        }

        for(InfoMateria info : materiasEnCarreras){
            ParCarreraMateria[] pares = info.getParesCarreraMateria();
            DataMateria data = new DataMateria(); 

            for(ParCarreraMateria par : pares){
                String carrera = par.getCarrera();
                String nombreMateria = par.getNombreMateria(); 
                
                if(!this.carreras.estaRegistrada(carrera)){
                    Materias materias = new Materias(); 
                    this.carreras.agregarCarrera(carrera, materias);
                }
                else{
                    Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
                    materiasCarrera.agregarMateria(nombreMateria, data); 
                }

            }
        }
    }

    public void inscribir(String estudiante, String carrera, String materia){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public void agregarDocente(CargoDocente cargo, String carrera, String materia){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public int[] plantelDocente(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public void cerrarMateria(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public int inscriptos(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public boolean excedeCupo(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public String[] carreras(){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public String[] materias(String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public int materiasInscriptas(String estudiante){
        throw new UnsupportedOperationException("Método no implementado aún");
    }
}
