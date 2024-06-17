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
                data.agregarNombre(nombreMateria);

                if(!this.carreras.estaRegistrada(carrera)){
                    Materias materias = new Materias(); 
                    this.carreras.agregarCarrera(carrera, materias);
                    materias.agregarMateria(nombreMateria, data);
                    data.agregarTrie(materias);

                }
                else{
                    Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
                    materiasCarrera.agregarMateria(nombreMateria, data); 
                    data.agregarTrie(materiasCarrera);
                }

            }
        }
    }

    public void inscribir(String estudiante, String carrera, String materia){
        this.estudiantes.inscribirAMateria(estudiante);
        Materias materiasCarrera =  this.carreras.obtenerMateriasCarrera(carrera);
        DataMateria  materiaCarrera = materiasCarrera.obtenerMateria(materia); 
        materiaCarrera.agregarAlumno(materia);
    }

    public void agregarDocente(CargoDocente cargo, String carrera, String materia){
        Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);
        materiaCarrera.agregarDocente(cargo);  
    }

    public int[] plantelDocente(String materia, String carrera){
        Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);
        return materiaCarrera.obtenerPlantel(); 
    }

    public void cerrarMateria(String materia, String carrera){
        throw new UnsupportedOperationException("Método no implementado aún");
    }

    public int inscriptos(String materia, String carrera){
        Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);
        return materiaCarrera.cantInscriptos(); 
    }

    public boolean excedeCupo(String materia, String carrera){
        Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
        DataMateria materiaCarrera = materiasCarrera.obtenerMateria(materia);
        return materiaCarrera.excedeCupo(); 
    }

    public String[] carreras(){
        return this.carreras.obtenerListaDeCarreras();

    }

    public String[] materias(String carrera){
        Materias materiasCarrera = this.carreras.obtenerMateriasCarrera(carrera);
        return materiasCarrera.obtenerListaDeMaterias(); 
    }

    public int materiasInscriptas(String estudiante){
        return estudiantes.cantMateriasInscriptas(estudiante); 
    }
}
